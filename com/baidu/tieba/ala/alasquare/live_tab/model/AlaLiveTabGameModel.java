package com.baidu.tieba.ala.alasquare.live_tab.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.subtablist.message.SdkLiveInfoListResponsedMessage;
import d.b.b.j.e.n;
import java.util.List;
/* loaded from: classes4.dex */
public class AlaLiveTabGameModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public int f14771e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f14772f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f14773g;
    public d.b.i0.t.d.c.g.b i;
    public String j;
    public String k;
    public b l;
    public HttpMessageListener m = new a(AlaCmdConfigHttp.CMD_ALA_GAME_LIVE_LIST);

    /* renamed from: h  reason: collision with root package name */
    public BdUniqueId f14774h = BdUniqueId.gen();

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021150 && (httpResponsedMessage instanceof SdkLiveInfoListResponsedMessage) && httpResponsedMessage.getOrginalMessage().getTag() == AlaLiveTabGameModel.this.f14774h) {
                SdkLiveInfoListResponsedMessage sdkLiveInfoListResponsedMessage = (SdkLiveInfoListResponsedMessage) httpResponsedMessage;
                if (sdkLiveInfoListResponsedMessage.getError() != 0 || !sdkLiveInfoListResponsedMessage.isSuccess()) {
                    if (AlaLiveTabGameModel.this.l != null) {
                        AlaLiveTabGameModel.this.l.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), AlaLiveTabGameModel.this.f14773g);
                    }
                } else {
                    if (AlaLiveTabGameModel.this.f14773g) {
                        AlaLiveTabGameModel.this.i.a(sdkLiveInfoListResponsedMessage.getLiveList(), sdkLiveInfoListResponsedMessage.hasMore());
                    } else {
                        if (AlaLiveTabGameModel.this.i != null) {
                            AlaLiveTabGameModel.this.i.b();
                        }
                        AlaLiveTabGameModel.this.i = new d.b.i0.t.d.c.g.b(sdkLiveInfoListResponsedMessage.getLiveList(), sdkLiveInfoListResponsedMessage.hasMore(), AlaLiveTabGameModel.this.j, AlaLiveTabGameModel.this.k);
                    }
                    AlaLiveTabGameModel alaLiveTabGameModel = AlaLiveTabGameModel.this;
                    alaLiveTabGameModel.f14772f = alaLiveTabGameModel.i.f();
                    AlaLiveTabGameModel.C(AlaLiveTabGameModel.this);
                    if (AlaLiveTabGameModel.this.l != null) {
                        AlaLiveTabGameModel.this.l.a(AlaLiveTabGameModel.this.f14772f, AlaLiveTabGameModel.this.i.d());
                    }
                }
                AlaLiveTabGameModel.this.f14773g = false;
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(boolean z, List<n> list);

        void b(int i, String str, boolean z);
    }

    public AlaLiveTabGameModel(TbPageContext tbPageContext, b bVar) {
        this.l = bVar;
    }

    public static /* synthetic */ int C(AlaLiveTabGameModel alaLiveTabGameModel) {
        int i = alaLiveTabGameModel.f14771e;
        alaLiveTabGameModel.f14771e = i + 1;
        return i;
    }

    public void D() {
        if (!this.f14772f || this.f14773g) {
            return;
        }
        this.f14773g = true;
        F(this.f14771e);
    }

    public void E() {
        this.f14773g = false;
        this.f14771e = 1;
        F(1);
    }

    public final void F(int i) {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GAME_LIVE_LIST);
        httpMessage.addParam("ps", 20);
        httpMessage.addParam(Config.PACKAGE_NAME, this.f14771e);
        httpMessage.addParam("fid", this.j);
        httpMessage.addParam("fname", this.k);
        httpMessage.setTag(this.f14774h);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void G(String str, String str2) {
        this.j = str;
        this.k = str2;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void init() {
        MessageManager.getInstance().registerListener(this.m);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.m);
    }
}
