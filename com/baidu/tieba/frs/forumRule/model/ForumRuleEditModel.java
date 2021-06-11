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
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.frs.forumRule.message.ResponseHttpRorumRuleCommitMessage;
import com.baidu.tieba.frs.forumRule.message.ResponseHttpRorumRuleDraftMessage;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes4.dex */
public class ForumRuleEditModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public final d.a.n0.r0.q1.b.b f15431e;

    /* renamed from: f  reason: collision with root package name */
    public int f15432f;

    /* renamed from: g  reason: collision with root package name */
    public HttpMessageListener f15433g;

    /* renamed from: h  reason: collision with root package name */
    public HttpMessageListener f15434h;

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || !(httpResponsedMessage instanceof ResponseHttpRorumRuleDraftMessage)) {
                ForumRuleEditModel.this.f15431e.draftCallback(0, null, "");
                return;
            }
            ResponseHttpRorumRuleDraftMessage responseHttpRorumRuleDraftMessage = (ResponseHttpRorumRuleDraftMessage) httpResponsedMessage;
            if (responseHttpRorumRuleDraftMessage != null) {
                ForumRuleEditModel.this.f15431e.draftCallback(responseHttpRorumRuleDraftMessage.getError(), responseHttpRorumRuleDraftMessage.getData(), responseHttpRorumRuleDraftMessage.getErrorString());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends HttpMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            ResponseHttpRorumRuleCommitMessage responseHttpRorumRuleCommitMessage;
            if (httpResponsedMessage == null || !(httpResponsedMessage instanceof ResponseHttpRorumRuleCommitMessage) || (responseHttpRorumRuleCommitMessage = (ResponseHttpRorumRuleCommitMessage) httpResponsedMessage) == null || ForumRuleEditModel.this.f15432f == -1) {
                return;
            }
            ForumRuleEditModel.this.f15431e.commitCallback(responseHttpRorumRuleCommitMessage.getError(), responseHttpRorumRuleCommitMessage.getErrorString(), ForumRuleEditModel.this.f15432f == 1);
            ForumRuleEditModel.this.f15432f = -1;
        }
    }

    public ForumRuleEditModel(TbPageContext tbPageContext, d.a.n0.r0.q1.b.b bVar, String str) {
        super(tbPageContext);
        this.f15432f = -1;
        this.f15433g = new a(CmdConfigHttp.CMD_FORUM_RULES_DRAFT);
        this.f15434h = new b(CmdConfigHttp.CMD_FORUM_RULES_COMMIT);
        this.f15431e = bVar;
        B();
    }

    public void A(String str) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FORUM_RULES_DRAFT);
        httpMessage.addParam("forum_id", str);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public final void B() {
        d.a.n0.e3.d0.a.e(CmdConfigHttp.CMD_FORUM_RULES_DRAFT, TbConfig.URL_FORUM_RULES_DRAFT, ResponseHttpRorumRuleDraftMessage.class, true, true, true, true);
        d.a.n0.e3.d0.a.e(CmdConfigHttp.CMD_FORUM_RULES_COMMIT, TbConfig.URL_FORUM_RULES_COMMIT, ResponseHttpRorumRuleCommitMessage.class, true, true, true, true);
        registerListener(this.f15433g);
        registerListener(this.f15434h);
    }

    public final String C(List<ForumRuleBaseData.ForumRuleItemData> list) {
        if (ListUtils.getCount(list) <= 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (int i2 = 0; i2 < list.size(); i2++) {
            ForumRuleBaseData.ForumRuleItemData forumRuleItemData = list.get(i2);
            if (forumRuleItemData != null) {
                jSONArray.put(forumRuleItemData.makeJSONObject());
            }
        }
        return jSONArray.toString();
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void z(String str, ForumRuleBaseData forumRuleBaseData, boolean z) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FORUM_RULES_COMMIT);
        httpMessage.addParam("forum_id", Long.parseLong(str));
        httpMessage.addParam("title", forumRuleBaseData.getTitle());
        httpMessage.addParam("preface", forumRuleBaseData.getPreface());
        httpMessage.addParam("rules", C(forumRuleBaseData.getList()));
        httpMessage.addParam("is_draft", z ? 1 : 0);
        this.f15432f = z ? 1 : 0;
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}
