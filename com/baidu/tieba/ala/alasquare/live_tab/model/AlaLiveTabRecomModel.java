package com.baidu.tieba.ala.alasquare.live_tab.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment;
import com.baidu.tieba.ala.alasquare.live_tab.message.AlaTabLiveResponsedMessage;
import com.baidu.webkit.internal.ETAG;
import d.a.c.e.p.l;
import d.a.c.k.e.n;
import d.a.n0.v.d.c.e.j;
import java.util.List;
/* loaded from: classes4.dex */
public class AlaLiveTabRecomModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f13793e;

    /* renamed from: f  reason: collision with root package name */
    public int f13794f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f13795g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f13796h;
    public d.a.n0.v.d.c.g.b j;
    public long k;
    public int l;
    public b m;
    public HttpMessageListener n = new a(AlaCmdConfigHttp.CMD_ALA_GET_TAB_LIVE_INFO);

    /* renamed from: i  reason: collision with root package name */
    public BdUniqueId f13797i = BdUniqueId.gen();

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021141 && (httpResponsedMessage instanceof AlaTabLiveResponsedMessage) && httpResponsedMessage.getOrginalMessage().getTag() == AlaLiveTabRecomModel.this.f13797i) {
                AlaTabLiveResponsedMessage alaTabLiveResponsedMessage = (AlaTabLiveResponsedMessage) httpResponsedMessage;
                d.a.n0.v.d.c.e.b bVar = new d.a.n0.v.d.c.e.b();
                if (alaTabLiveResponsedMessage.getError() != 0 || !alaTabLiveResponsedMessage.isSuccess()) {
                    if (AlaLiveTabRecomModel.this.m != null) {
                        AlaLiveTabRecomModel.this.m.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), AlaLiveTabRecomModel.this.f13796h);
                    }
                    bVar.f65209a = false;
                    httpResponsedMessage.getError();
                    httpResponsedMessage.getErrorString();
                } else {
                    j jVar = alaTabLiveResponsedMessage.tabAllLiveInfo;
                    if (AlaLiveTabRecomModel.this.f13796h) {
                        AlaLiveTabRecomModel.this.j.a(jVar);
                        AlaLiveTabRecomModel.C(AlaLiveTabRecomModel.this);
                    } else {
                        AlaLiveTabFragment.m++;
                        if (AlaLiveTabRecomModel.this.j != null) {
                            AlaLiveTabRecomModel.this.j.b();
                        }
                        AlaLiveTabRecomModel.this.j = new d.a.n0.v.d.c.g.b(alaTabLiveResponsedMessage);
                    }
                    AlaLiveTabRecomModel alaLiveTabRecomModel = AlaLiveTabRecomModel.this;
                    alaLiveTabRecomModel.f13795g = alaLiveTabRecomModel.j.h();
                    if (AlaLiveTabRecomModel.this.m != null) {
                        AlaLiveTabRecomModel.this.m.a(AlaLiveTabRecomModel.this.f13795g, AlaLiveTabRecomModel.this.j.d());
                    }
                    bVar.f65209a = true;
                }
                bVar.f65210b = AlaLiveTabRecomModel.this.f13796h;
                bVar.f65211c = alaTabLiveResponsedMessage.superEntranceInfo;
                AlaLiveTabRecomModel.this.G(bVar);
                AlaLiveTabRecomModel.this.f13796h = false;
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(boolean z, List<n> list);

        void b(int i2, String str, boolean z);
    }

    public AlaLiveTabRecomModel(TbPageContext tbPageContext, b bVar, int i2) {
        this.f13793e = tbPageContext;
        this.m = bVar;
        this.l = i2;
    }

    public static /* synthetic */ int C(AlaLiveTabRecomModel alaLiveTabRecomModel) {
        int i2 = alaLiveTabRecomModel.f13794f;
        alaLiveTabRecomModel.f13794f = i2 + 1;
        return i2;
    }

    public final void G(d.a.n0.v.d.c.e.b bVar) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_LIVE_TAB_RESPONSE, bVar));
    }

    public final void H(int i2, int i3, int i4) {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GET_TAB_LIVE_INFO);
        httpMessage.addParam("tab_id", this.l);
        String str = "N";
        if (d.a.c.e.p.j.z()) {
            if (d.a.c.e.p.j.H()) {
                str = "1_0";
            } else if (d.a.c.e.p.j.v()) {
                str = "0_13";
            } else if (d.a.c.e.p.j.u()) {
                str = "0_3";
            } else if (d.a.c.e.p.j.t()) {
                str = "0_2";
            }
        }
        httpMessage.addParam("network", str);
        httpMessage.addParam("ua_str", l.k(this.f13793e.getPageActivity()) + "_" + l.i(this.f13793e.getPageActivity()) + "_android_" + TbConfig.getVersion());
        httpMessage.addParam(ETAG.KEY_STATISTICS_SEESIONID, this.k);
        httpMessage.addParam("refresh_type", i3);
        httpMessage.addParam("big_refresh_count", i4);
        httpMessage.setTag(this.f13797i);
        MessageManager.getInstance().sendMessage(httpMessage);
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
        MessageManager.getInstance().registerListener(this.n);
    }

    public void loadMore() {
        if (!this.f13795g || this.f13796h) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.k >= 1800000) {
            this.k = currentTimeMillis;
        }
        this.f13796h = true;
        H(this.f13794f + 1, 1, AlaLiveTabFragment.m - 1);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.n);
    }

    public void refresh() {
        this.k = System.currentTimeMillis();
        this.f13796h = false;
        this.f13794f = 1;
        H(1, 0, AlaLiveTabFragment.m);
    }
}
