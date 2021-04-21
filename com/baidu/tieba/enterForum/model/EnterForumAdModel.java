package com.baidu.tieba.enterForum.model;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.b.c.a.j;
import d.b.j0.c3.c;
import d.b.j0.i0.d.b;
/* loaded from: classes4.dex */
public class EnterForumAdModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public b f15139e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f15140f = false;

    /* renamed from: g  reason: collision with root package name */
    public HttpMessageListener f15141g = new a(CmdConfigHttp.CMD_ENTER_FORUM_AD_REQUEST);

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof EnterForumAdResponsedMessage) {
                EnterForumAdResponsedMessage enterForumAdResponsedMessage = (EnterForumAdResponsedMessage) httpResponsedMessage;
                if (enterForumAdResponsedMessage.hasError()) {
                    EnterForumAdModel.this.f15139e = null;
                } else {
                    EnterForumAdModel.this.f15139e = enterForumAdResponsedMessage.getAdData();
                    if (EnterForumAdModel.this.mLoadDataCallBack != null) {
                        EnterForumAdModel.this.mLoadDataCallBack.c(EnterForumAdModel.this.f15139e);
                    }
                }
                EnterForumAdModel.this.f15140f = false;
            }
        }
    }

    public EnterForumAdModel() {
        this.unique_id = BdUniqueId.gen();
        MessageManager.getInstance().registerListener(this.f15141g);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public b x() {
        return this.f15139e;
    }

    public void y() {
        MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ENTER_FORUM_AD_REQUEST));
    }

    public void z(Context context) {
        b bVar;
        if (this.f15140f || (bVar = this.f15139e) == null || !bVar.a()) {
            return;
        }
        c.g().c(j.a(context).getUniqueId(), d.b.j0.c3.a.i("a025", "common_fill", true, 1, 5));
        this.f15140f = true;
    }
}
