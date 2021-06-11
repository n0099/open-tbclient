package com.baidu.tieba.homepage.channel.model;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.atomData.LowFlowsActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.homepage.channel.message.HomePageChannelTabHttpResponsedMessage;
import d.a.m0.r.q.a2;
import d.a.m0.s.c.n;
import d.a.n0.b1.j.e;
import d.a.n0.b1.j.f;
import d.a.n0.b1.j.h.c;
import java.util.List;
/* loaded from: classes4.dex */
public class ChannelTabNetFeedModel extends BdBaseModel implements f {

    /* renamed from: e  reason: collision with root package name */
    public boolean f16183e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f16184f;

    /* renamed from: g  reason: collision with root package name */
    public int f16185g;

    /* renamed from: h  reason: collision with root package name */
    public String f16186h;

    /* renamed from: i  reason: collision with root package name */
    public e f16187i;
    public d.a.n0.b1.b.b.a j;
    public HttpMessageListener k;

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            ChannelTabNetFeedModel.this.f16184f = false;
            if (httpResponsedMessage == null || !(httpResponsedMessage instanceof HomePageChannelTabHttpResponsedMessage)) {
                return;
            }
            d.a.n0.b1.b.a.a aVar = ((HomePageChannelTabHttpResponsedMessage) httpResponsedMessage).channelTabRespData;
            ChannelTabNetFeedModel.this.mErrorCode = httpResponsedMessage.getError();
            ChannelTabNetFeedModel.this.mErrorString = httpResponsedMessage.getErrorString();
            ErrorData errorData = new ErrorData();
            errorData.setError_code(ChannelTabNetFeedModel.this.mErrorCode);
            errorData.setError_msg(ChannelTabNetFeedModel.this.mErrorString);
            if (ChannelTabNetFeedModel.this.f16187i == null) {
                return;
            }
            if (ChannelTabNetFeedModel.this.mErrorCode != 0 || aVar == null) {
                ChannelTabNetFeedModel.this.f16187i.onServerError(errorData);
            } else {
                ChannelTabNetFeedModel.this.F(aVar);
            }
        }
    }

    public ChannelTabNetFeedModel(TbPageContext tbPageContext, e eVar) {
        super(tbPageContext);
        this.f16183e = true;
        this.f16184f = false;
        this.f16185g = 1;
        this.k = new a(CmdConfigHttp.CMD_HOME_CHANNEL_TAB_LIST);
        d.a.n0.e3.d0.a.e(CmdConfigHttp.CMD_HOME_CHANNEL_TAB_LIST, TbConfig.CMD_HMEPAGE_CHANNEL_LIST, HomePageChannelTabHttpResponsedMessage.class, true, true, true, true);
        this.j = new d.a.n0.b1.b.b.a();
        this.f16187i = eVar;
    }

    public final void E(int i2) {
        int i3;
        if (i2 == 2) {
            i3 = this.f16185g + 1;
        } else if (i2 != 1) {
            return;
        } else {
            i3 = 1;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_HOME_CHANNEL_TAB_LIST);
        httpMessage.addParam(LowFlowsActivityConfig.TAB_CODE, this.f16186h);
        httpMessage.addParam(Config.PACKAGE_NAME, i3);
        httpMessage.addParam("rn", 20);
        if ("local".equals(this.f16186h)) {
            httpMessage.addParam("app_pos", d.a.n0.t2.g0.a.e().b());
        }
        n c2 = TbSingleton.getInstance().getChannelConfigModel().c();
        if (c2 != null && !TextUtils.isEmpty(c2.e())) {
            httpMessage.addParam("tid", c2.e());
        }
        httpMessage.setTag(getUniqueId());
        this.f16184f = true;
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public final void F(d.a.n0.b1.b.a.a aVar) {
        if (this.f16187i != null) {
            c a2 = this.j.a(this.f16185g, this.f16183e, aVar);
            if (a2 != null) {
                this.f16185g = a2.f55592d;
            }
            this.f16187i.N(a2);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // d.a.n0.b1.j.f
    public boolean b() {
        d.a.n0.b1.b.b.a aVar = this.j;
        if (aVar == null) {
            return false;
        }
        return aVar.c();
    }

    @Override // d.a.n0.b1.j.f
    public void c(BdUniqueId bdUniqueId) {
        setUniqueId(bdUniqueId);
        MessageManager.getInstance().unRegisterListener(this.k);
        this.k.setTag(bdUniqueId);
        this.k.setSelfListener(true);
        registerListener(this.k);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
        super.cancelMessage();
        this.f16184f = false;
    }

    @Override // d.a.n0.b1.j.f
    public void destory() {
        MessageManager.getInstance().unRegisterListener(this.k);
        this.f16184f = false;
        this.f16183e = true;
    }

    @Override // d.a.n0.b1.j.f
    public List<a2> i() {
        d.a.n0.b1.b.b.a aVar = this.j;
        if (aVar == null) {
            return null;
        }
        return aVar.b();
    }

    @Override // d.a.n0.b1.j.f
    public void loadMore() {
        if (this.f16184f) {
            return;
        }
        this.f16183e = false;
        E(2);
    }

    @Override // d.a.n0.b1.j.f
    public void o(String str, String str2, int i2) {
        this.f16186h = str;
    }

    @Override // d.a.n0.b1.j.f
    public void refresh() {
        if (this.f16184f) {
            return;
        }
        this.f16183e = true;
        E(1);
    }
}
