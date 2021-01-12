package com.baidu.tieba.frs.forumRule.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ForumRuleBaseData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.frs.forumRule.a.b;
import com.baidu.tieba.frs.forumRule.message.ResponseHttpRorumRuleCommitMessage;
import com.baidu.tieba.frs.forumRule.message.ResponseHttpRorumRuleDraftMessage;
import com.baidu.tieba.tbadkCore.a.a;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class ForumRuleEditModel extends BdBaseModel {
    HttpMessageListener gGd;
    private final b jpR;
    private int jpS;
    HttpMessageListener jpT;

    public ForumRuleEditModel(TbPageContext tbPageContext, b bVar, String str) {
        super(tbPageContext);
        this.jpS = -1;
        this.gGd = new HttpMessageListener(CmdConfigHttp.CMD_FORUM_RULES_DRAFT) { // from class: com.baidu.tieba.frs.forumRule.model.ForumRuleEditModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || !(httpResponsedMessage instanceof ResponseHttpRorumRuleDraftMessage)) {
                    ForumRuleEditModel.this.jpR.a(0, null, "");
                    return;
                }
                ResponseHttpRorumRuleDraftMessage responseHttpRorumRuleDraftMessage = (ResponseHttpRorumRuleDraftMessage) httpResponsedMessage;
                if (responseHttpRorumRuleDraftMessage != null) {
                    ForumRuleEditModel.this.jpR.a(responseHttpRorumRuleDraftMessage.getError(), responseHttpRorumRuleDraftMessage.getData(), responseHttpRorumRuleDraftMessage.getErrorString());
                }
            }
        };
        this.jpT = new HttpMessageListener(CmdConfigHttp.CMD_FORUM_RULES_COMMIT) { // from class: com.baidu.tieba.frs.forumRule.model.ForumRuleEditModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                ResponseHttpRorumRuleCommitMessage responseHttpRorumRuleCommitMessage;
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof ResponseHttpRorumRuleCommitMessage) && (responseHttpRorumRuleCommitMessage = (ResponseHttpRorumRuleCommitMessage) httpResponsedMessage) != null && ForumRuleEditModel.this.jpS != -1) {
                    ForumRuleEditModel.this.jpR.m(responseHttpRorumRuleCommitMessage.getError(), responseHttpRorumRuleCommitMessage.getErrorString(), ForumRuleEditModel.this.jpS == 1);
                    ForumRuleEditModel.this.jpS = -1;
                }
            }
        };
        this.jpR = bVar;
        cFW();
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void JH(String str) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FORUM_RULES_DRAFT);
        httpMessage.addParam("forum_id", str);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void a(String str, ForumRuleBaseData forumRuleBaseData, boolean z) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FORUM_RULES_COMMIT);
        httpMessage.addParam("forum_id", Long.parseLong(str));
        httpMessage.addParam("title", forumRuleBaseData.getTitle());
        httpMessage.addParam("preface", forumRuleBaseData.getPreface());
        httpMessage.addParam("rules", dw(forumRuleBaseData.getList()));
        httpMessage.addParam("is_draft", z ? 1 : 0);
        this.jpS = z ? 1 : 0;
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    private void cFW() {
        a.c(CmdConfigHttp.CMD_FORUM_RULES_DRAFT, TbConfig.URL_FORUM_RULES_DRAFT, ResponseHttpRorumRuleDraftMessage.class, true, true, true, true);
        a.c(CmdConfigHttp.CMD_FORUM_RULES_COMMIT, TbConfig.URL_FORUM_RULES_COMMIT, ResponseHttpRorumRuleCommitMessage.class, true, true, true, true);
        registerListener(this.gGd);
        registerListener(this.jpT);
    }

    private String dw(List<ForumRuleBaseData.ForumRuleItemData> list) {
        if (x.getCount(list) <= 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                ForumRuleBaseData.ForumRuleItemData forumRuleItemData = list.get(i2);
                if (forumRuleItemData != null) {
                    jSONArray.put(forumRuleItemData.makeJSONObject());
                }
                i = i2 + 1;
            } else {
                return jSONArray.toString();
            }
        }
    }
}
