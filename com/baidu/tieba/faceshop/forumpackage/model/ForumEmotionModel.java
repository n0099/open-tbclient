package com.baidu.tieba.faceshop.forumpackage.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.faceshop.forumpackage.data.ForumEmotionData;
import com.baidu.tieba.faceshop.forumpackage.message.ForumEmotionCenterResponseMessage;
/* loaded from: classes4.dex */
public class ForumEmotionModel extends BdBaseModel {
    public static final int NUM_PER_PAGE = 10;
    public static final int PAGE_START = 1;

    /* renamed from: e  reason: collision with root package name */
    public int f14955e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f14956f;

    /* renamed from: g  reason: collision with root package name */
    public final d.a.n0.m0.z.b.b f14957g;

    /* renamed from: h  reason: collision with root package name */
    public final HttpMessageListener f14958h;

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Object extra;
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003389 && (httpResponsedMessage instanceof ForumEmotionCenterResponseMessage)) {
                b bVar = null;
                if (httpResponsedMessage.getOrginalMessage() != null && (extra = httpResponsedMessage.getOrginalMessage().getExtra()) != null && (extra instanceof b)) {
                    bVar = (b) extra;
                }
                ForumEmotionCenterResponseMessage forumEmotionCenterResponseMessage = (ForumEmotionCenterResponseMessage) httpResponsedMessage;
                ForumEmotionModel forumEmotionModel = ForumEmotionModel.this;
                ForumEmotionData forumEmotionData = forumEmotionCenterResponseMessage.data;
                forumEmotionModel.f14956f = forumEmotionData != null && forumEmotionData.has_more == 1;
                if (bVar != null) {
                    if (forumEmotionCenterResponseMessage.getStatusCode() == 200) {
                        if (forumEmotionCenterResponseMessage.getError() == 0 && forumEmotionCenterResponseMessage.data != null) {
                            if (ForumEmotionModel.this.f14955e == 1) {
                                bVar.y0(forumEmotionCenterResponseMessage.data);
                                return;
                            } else {
                                bVar.U(forumEmotionCenterResponseMessage.data);
                                return;
                            }
                        }
                        bVar.onFailed(forumEmotionCenterResponseMessage.getErrorString());
                        return;
                    }
                    bVar.onFailed(forumEmotionCenterResponseMessage.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void U(ForumEmotionData forumEmotionData);

        void onFailed(String str);

        void y0(ForumEmotionData forumEmotionData);
    }

    public ForumEmotionModel(TbPageContext<BaseFragmentActivity> tbPageContext) {
        super(tbPageContext);
        this.f14955e = 1;
        this.f14956f = true;
        this.f14957g = new d.a.n0.m0.z.b.b();
        this.f14958h = new a(CmdConfigHttp.CMD_GET_FORUM_EMOTION_PACKAGE);
        registerTask();
        this.f14958h.setTag(getUniqueId());
        this.f14958h.setSelfListener(true);
        registerListener(this.f14958h);
    }

    public void A(b bVar) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_FORUM_EMOTION_PACKAGE);
        int i2 = this.f14955e + 1;
        this.f14955e = i2;
        httpMessage.addParam(Config.PACKAGE_NAME, i2);
        httpMessage.addParam("rn", 10);
        httpMessage.addParam("forum_type", this.f14957g.a() == 1 ? "like_forum" : "all_forum");
        httpMessage.setExtra(bVar);
        sendMessage(httpMessage);
    }

    public void B(b bVar) {
        this.f14955e = 1;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_FORUM_EMOTION_PACKAGE);
        httpMessage.addParam(Config.PACKAGE_NAME, this.f14955e);
        httpMessage.addParam("rn", 10);
        httpMessage.addParam("forum_type", this.f14957g.a() == 1 ? "like_forum" : "all_forum");
        httpMessage.setExtra(bVar);
        sendMessage(httpMessage);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_FORUM_EMOTION_PACKAGE);
        return true;
    }

    public final void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_FORUM_EMOTION_PACKAGE, TbConfig.SERVER_ADDRESS + "c/e/meme/forumPackage");
        tbHttpMessageTask.setResponsedClass(ForumEmotionCenterResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public d.a.n0.m0.z.b.b y() {
        return this.f14957g;
    }

    public boolean z() {
        return this.f14956f;
    }
}
