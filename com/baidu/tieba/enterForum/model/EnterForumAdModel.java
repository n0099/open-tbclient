package com.baidu.tieba.enterForum.model;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.a.c.a.j;
import d.a.o0.d3.c;
import d.a.o0.j0.d.b;
/* loaded from: classes4.dex */
public class EnterForumAdModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public b f14623e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f14624f = false;

    /* renamed from: g  reason: collision with root package name */
    public HttpMessageListener f14625g = new a(CmdConfigHttp.CMD_ENTER_FORUM_AD_REQUEST);

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof EnterForumAdResponsedMessage) {
                EnterForumAdResponsedMessage enterForumAdResponsedMessage = (EnterForumAdResponsedMessage) httpResponsedMessage;
                if (enterForumAdResponsedMessage.hasError()) {
                    EnterForumAdModel.this.f14623e = null;
                } else {
                    EnterForumAdModel.this.f14623e = enterForumAdResponsedMessage.getAdData();
                    if (EnterForumAdModel.this.mLoadDataCallBack != null) {
                        EnterForumAdModel.this.mLoadDataCallBack.c(EnterForumAdModel.this.f14623e);
                    }
                }
                EnterForumAdModel.this.f14624f = false;
            }
        }
    }

    public EnterForumAdModel() {
        this.unique_id = BdUniqueId.gen();
        MessageManager.getInstance().registerListener(this.f14625g);
    }

    public b B() {
        return this.f14623e;
    }

    public void C() {
        MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ENTER_FORUM_AD_REQUEST));
    }

    public void D(Context context) {
        b bVar;
        if (this.f14624f || (bVar = this.f14623e) == null || !bVar.a()) {
            return;
        }
        c.g().c(j.a(context).getUniqueId(), d.a.o0.d3.a.i("a025", "common_fill", true, 1, 5));
        this.f14624f = true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }
}
