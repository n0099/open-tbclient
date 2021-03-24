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
    public int f15851e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f15852f;

    /* renamed from: g  reason: collision with root package name */
    public final d.b.i0.l0.z.b.b f15853g;

    /* renamed from: h  reason: collision with root package name */
    public final HttpMessageListener f15854h;

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public a(int i) {
            super(i);
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
                forumEmotionModel.f15852f = forumEmotionData != null && forumEmotionData.has_more == 1;
                if (bVar != null) {
                    if (forumEmotionCenterResponseMessage.getStatusCode() == 200) {
                        if (forumEmotionCenterResponseMessage.getError() == 0 && forumEmotionCenterResponseMessage.data != null) {
                            if (ForumEmotionModel.this.f15851e == 1) {
                                bVar.s0(forumEmotionCenterResponseMessage.data);
                                return;
                            } else {
                                bVar.e(forumEmotionCenterResponseMessage.data);
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
        void e(ForumEmotionData forumEmotionData);

        void onFailed(String str);

        void s0(ForumEmotionData forumEmotionData);
    }

    public ForumEmotionModel(TbPageContext<BaseFragmentActivity> tbPageContext) {
        super(tbPageContext);
        this.f15851e = 1;
        this.f15852f = true;
        this.f15853g = new d.b.i0.l0.z.b.b();
        this.f15854h = new a(CmdConfigHttp.CMD_GET_FORUM_EMOTION_PACKAGE);
        registerTask();
        this.f15854h.setTag(getUniqueId());
        this.f15854h.setSelfListener(true);
        registerListener(this.f15854h);
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

    public d.b.i0.l0.z.b.b u() {
        return this.f15853g;
    }

    public boolean v() {
        return this.f15852f;
    }

    public void w(b bVar) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_FORUM_EMOTION_PACKAGE);
        int i = this.f15851e + 1;
        this.f15851e = i;
        httpMessage.addParam(Config.PACKAGE_NAME, i);
        httpMessage.addParam("rn", 10);
        httpMessage.addParam("forum_type", this.f15853g.a() == 1 ? "like_forum" : "all_forum");
        httpMessage.setExtra(bVar);
        sendMessage(httpMessage);
    }

    public void x(b bVar) {
        this.f15851e = 1;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_FORUM_EMOTION_PACKAGE);
        httpMessage.addParam(Config.PACKAGE_NAME, this.f15851e);
        httpMessage.addParam("rn", 10);
        httpMessage.addParam("forum_type", this.f15853g.a() == 1 ? "like_forum" : "all_forum");
        httpMessage.setExtra(bVar);
        sendMessage(httpMessage);
    }
}
