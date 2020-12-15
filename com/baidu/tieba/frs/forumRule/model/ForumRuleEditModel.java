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
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.frs.forumRule.b.b;
import com.baidu.tieba.frs.forumRule.message.ResponseHttpRorumRuleCommitMessage;
import com.baidu.tieba.frs.forumRule.message.ResponseHttpRorumRuleDraftMessage;
import com.baidu.tieba.tbadkCore.a.a;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes22.dex */
public class ForumRuleEditModel extends BdBaseModel {
    HttpMessageListener gzG;
    private final b jhX;
    private int jhY;
    HttpMessageListener jhZ;

    public ForumRuleEditModel(TbPageContext tbPageContext, b bVar, String str) {
        super(tbPageContext);
        this.jhY = -1;
        this.gzG = new HttpMessageListener(CmdConfigHttp.CMD_FORUM_RULES_DRAFT) { // from class: com.baidu.tieba.frs.forumRule.model.ForumRuleEditModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || !(httpResponsedMessage instanceof ResponseHttpRorumRuleDraftMessage)) {
                    ForumRuleEditModel.this.jhX.a(0, null, "");
                    return;
                }
                ResponseHttpRorumRuleDraftMessage responseHttpRorumRuleDraftMessage = (ResponseHttpRorumRuleDraftMessage) httpResponsedMessage;
                if (responseHttpRorumRuleDraftMessage != null) {
                    ForumRuleEditModel.this.jhX.a(responseHttpRorumRuleDraftMessage.getError(), responseHttpRorumRuleDraftMessage.getData(), responseHttpRorumRuleDraftMessage.getErrorString());
                }
            }
        };
        this.jhZ = new HttpMessageListener(CmdConfigHttp.CMD_FORUM_RULES_COMMIT) { // from class: com.baidu.tieba.frs.forumRule.model.ForumRuleEditModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                ResponseHttpRorumRuleCommitMessage responseHttpRorumRuleCommitMessage;
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof ResponseHttpRorumRuleCommitMessage) && (responseHttpRorumRuleCommitMessage = (ResponseHttpRorumRuleCommitMessage) httpResponsedMessage) != null && ForumRuleEditModel.this.jhY != -1) {
                    ForumRuleEditModel.this.jhX.m(responseHttpRorumRuleCommitMessage.getError(), responseHttpRorumRuleCommitMessage.getErrorString(), ForumRuleEditModel.this.jhY == 1);
                    ForumRuleEditModel.this.jhY = -1;
                }
            }
        };
        this.jhX = bVar;
        cGO();
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void KS(String str) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FORUM_RULES_DRAFT);
        httpMessage.addParam("forum_id", str);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void a(String str, ForumRuleBaseData forumRuleBaseData, boolean z) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FORUM_RULES_COMMIT);
        httpMessage.addParam("forum_id", Long.parseLong(str));
        httpMessage.addParam("title", forumRuleBaseData.getTitle());
        httpMessage.addParam("preface", forumRuleBaseData.getPreface());
        httpMessage.addParam("rules", m38do(forumRuleBaseData.getList()));
        httpMessage.addParam("is_draft", z ? 1 : 0);
        this.jhY = z ? 1 : 0;
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    private void cGO() {
        a.c(CmdConfigHttp.CMD_FORUM_RULES_DRAFT, TbConfig.URL_FORUM_RULES_DRAFT, ResponseHttpRorumRuleDraftMessage.class, true, true, true, true);
        a.c(CmdConfigHttp.CMD_FORUM_RULES_COMMIT, TbConfig.URL_FORUM_RULES_COMMIT, ResponseHttpRorumRuleCommitMessage.class, true, true, true, true);
        registerListener(this.gzG);
        registerListener(this.jhZ);
    }

    /* renamed from: do  reason: not valid java name */
    private String m38do(List<ForumRuleBaseData.ForumRuleItemData> list) {
        if (y.getCount(list) <= 0) {
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
