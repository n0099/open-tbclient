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
import d.b.b.e.p.l;
import d.b.b.j.e.n;
import d.b.i0.t.d.c.e.j;
import d.b.i0.t.d.c.g.c;
import java.util.List;
/* loaded from: classes4.dex */
public class AlaLiveTabRecomModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f14777e;

    /* renamed from: f  reason: collision with root package name */
    public int f14778f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f14779g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f14780h;
    public c j;
    public long k;
    public b l;
    public HttpMessageListener m = new a(AlaCmdConfigHttp.CMD_ALA_GET_TAB_LIVE_INFO);
    public BdUniqueId i = BdUniqueId.gen();

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021141 && (httpResponsedMessage instanceof AlaTabLiveResponsedMessage) && httpResponsedMessage.getOrginalMessage().getTag() == AlaLiveTabRecomModel.this.i) {
                AlaTabLiveResponsedMessage alaTabLiveResponsedMessage = (AlaTabLiveResponsedMessage) httpResponsedMessage;
                d.b.i0.t.d.c.e.b bVar = new d.b.i0.t.d.c.e.b();
                if (alaTabLiveResponsedMessage.getError() != 0 || !alaTabLiveResponsedMessage.isSuccess()) {
                    if (AlaLiveTabRecomModel.this.l != null) {
                        AlaLiveTabRecomModel.this.l.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), AlaLiveTabRecomModel.this.f14780h);
                    }
                    bVar.f60322a = false;
                    httpResponsedMessage.getError();
                    httpResponsedMessage.getErrorString();
                } else {
                    j jVar = alaTabLiveResponsedMessage.tabAllLiveInfo;
                    if (AlaLiveTabRecomModel.this.f14780h) {
                        AlaLiveTabRecomModel.this.j.a(jVar);
                        AlaLiveTabRecomModel.y(AlaLiveTabRecomModel.this);
                    } else {
                        AlaLiveTabFragment.m++;
                        if (AlaLiveTabRecomModel.this.j != null) {
                            AlaLiveTabRecomModel.this.j.b();
                        }
                        AlaLiveTabRecomModel.this.j = new c(alaTabLiveResponsedMessage);
                    }
                    AlaLiveTabRecomModel alaLiveTabRecomModel = AlaLiveTabRecomModel.this;
                    alaLiveTabRecomModel.f14779g = alaLiveTabRecomModel.j.h();
                    if (AlaLiveTabRecomModel.this.l != null) {
                        AlaLiveTabRecomModel.this.l.a(AlaLiveTabRecomModel.this.f14779g, AlaLiveTabRecomModel.this.j.d());
                    }
                    bVar.f60322a = true;
                }
                bVar.f60323b = AlaLiveTabRecomModel.this.f14780h;
                bVar.f60324c = alaTabLiveResponsedMessage.superEntranceInfo;
                AlaLiveTabRecomModel.this.C(bVar);
                AlaLiveTabRecomModel.this.f14780h = false;
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(boolean z, List<n> list);

        void b(int i, String str, boolean z);
    }

    public AlaLiveTabRecomModel(TbPageContext tbPageContext, b bVar) {
        this.f14777e = tbPageContext;
        this.l = bVar;
    }

    public static /* synthetic */ int y(AlaLiveTabRecomModel alaLiveTabRecomModel) {
        int i = alaLiveTabRecomModel.f14778f;
        alaLiveTabRecomModel.f14778f = i + 1;
        return i;
    }

    public final void C(d.b.i0.t.d.c.e.b bVar) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_LIVE_TAB_RESPONSE, bVar));
    }

    public void D() {
        if (!this.f14779g || this.f14780h) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.k >= 1800000) {
            this.k = currentTimeMillis;
        }
        this.f14780h = true;
        F(this.f14778f + 1, 1, AlaLiveTabFragment.m - 1);
    }

    public void E() {
        this.k = System.currentTimeMillis();
        this.f14780h = false;
        this.f14778f = 1;
        F(1, 0, AlaLiveTabFragment.m);
    }

    public final void F(int i, int i2, int i3) {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GET_TAB_LIVE_INFO);
        httpMessage.addParam("tab_id", 1);
        String str = "N";
        if (d.b.b.e.p.j.z()) {
            if (d.b.b.e.p.j.H()) {
                str = "1_0";
            } else if (d.b.b.e.p.j.v()) {
                str = "0_13";
            } else if (d.b.b.e.p.j.u()) {
                str = "0_3";
            } else if (d.b.b.e.p.j.t()) {
                str = "0_2";
            }
        }
        httpMessage.addParam("network", str);
        httpMessage.addParam("ua_str", l.k(this.f14777e.getPageActivity()) + "_" + l.i(this.f14777e.getPageActivity()) + "_android_" + TbConfig.getVersion());
        httpMessage.addParam(ETAG.KEY_STATISTICS_SEESIONID, this.k);
        httpMessage.addParam("refresh_type", i2);
        httpMessage.addParam("big_refresh_count", i3);
        httpMessage.setTag(this.i);
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
        MessageManager.getInstance().registerListener(this.m);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.m);
    }
}
