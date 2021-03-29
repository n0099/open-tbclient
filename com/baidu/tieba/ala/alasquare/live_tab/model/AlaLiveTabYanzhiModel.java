package com.baidu.tieba.ala.alasquare.live_tab.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment;
import com.baidu.tieba.ala.alasquare.live_tab.message.AlaTabLiveResponsedMessage;
import com.baidu.webkit.internal.ETAG;
import d.b.b.e.p.l;
import d.b.b.j.e.n;
import d.b.i0.t.d.c.e.j;
import d.b.i0.t.d.c.g.d;
import java.util.List;
/* loaded from: classes4.dex */
public class AlaLiveTabYanzhiModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f14782e;

    /* renamed from: f  reason: collision with root package name */
    public int f14783f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f14784g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f14785h;
    public d j;
    public long k;
    public String l;
    public String m;
    public b n;
    public HttpMessageListener o = new a(AlaCmdConfigHttp.CMD_ALA_GET_TAB_LIVE_INFO);
    public BdUniqueId i = BdUniqueId.gen();

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021141 && (httpResponsedMessage instanceof AlaTabLiveResponsedMessage) && httpResponsedMessage.getOrginalMessage().getTag() == AlaLiveTabYanzhiModel.this.i) {
                AlaTabLiveResponsedMessage alaTabLiveResponsedMessage = (AlaTabLiveResponsedMessage) httpResponsedMessage;
                if (alaTabLiveResponsedMessage.getError() != 0 || !alaTabLiveResponsedMessage.isSuccess()) {
                    if (AlaLiveTabYanzhiModel.this.n != null) {
                        AlaLiveTabYanzhiModel.this.n.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), AlaLiveTabYanzhiModel.this.f14785h);
                    }
                } else {
                    j jVar = alaTabLiveResponsedMessage.tabAllLiveInfo;
                    if (AlaLiveTabYanzhiModel.this.f14785h) {
                        AlaLiveTabYanzhiModel.this.j.a(jVar);
                        AlaLiveTabYanzhiModel.y(AlaLiveTabYanzhiModel.this);
                    } else {
                        AlaLiveTabFragment.n++;
                        if (AlaLiveTabYanzhiModel.this.j != null) {
                            AlaLiveTabYanzhiModel.this.j.b();
                        }
                        AlaLiveTabYanzhiModel alaLiveTabYanzhiModel = AlaLiveTabYanzhiModel.this;
                        alaLiveTabYanzhiModel.j = new d(jVar, alaLiveTabYanzhiModel.l, AlaLiveTabYanzhiModel.this.m);
                    }
                    AlaLiveTabYanzhiModel alaLiveTabYanzhiModel2 = AlaLiveTabYanzhiModel.this;
                    alaLiveTabYanzhiModel2.f14784g = alaLiveTabYanzhiModel2.j.f();
                    if (AlaLiveTabYanzhiModel.this.n != null) {
                        AlaLiveTabYanzhiModel.this.n.a(AlaLiveTabYanzhiModel.this.f14784g, AlaLiveTabYanzhiModel.this.j.d());
                    }
                }
                AlaLiveTabYanzhiModel.this.f14785h = false;
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(boolean z, List<n> list);

        void b(int i, String str, boolean z);
    }

    public AlaLiveTabYanzhiModel(TbPageContext tbPageContext, b bVar) {
        this.f14782e = tbPageContext;
        this.n = bVar;
    }

    public static /* synthetic */ int y(AlaLiveTabYanzhiModel alaLiveTabYanzhiModel) {
        int i = alaLiveTabYanzhiModel.f14783f;
        alaLiveTabYanzhiModel.f14783f = i + 1;
        return i;
    }

    public void D() {
        if (!this.f14784g || this.f14785h) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.k >= 1800000) {
            this.k = currentTimeMillis;
        }
        this.f14785h = true;
        F(this.f14783f + 1, 1, AlaLiveTabFragment.n - 1);
    }

    public void E() {
        this.k = System.currentTimeMillis();
        this.f14785h = false;
        this.f14783f = 1;
        F(1, 0, AlaLiveTabFragment.n);
    }

    public final void F(int i, int i2, int i3) {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GET_TAB_LIVE_INFO);
        httpMessage.addParam("tab_id", 2);
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
        httpMessage.addParam("ua_str", l.k(this.f14782e.getPageActivity()) + "_" + l.i(this.f14782e.getPageActivity()) + "_android_" + TbConfig.getVersion());
        httpMessage.addParam(ETAG.KEY_STATISTICS_SEESIONID, this.k);
        httpMessage.addParam("refresh_type", i2);
        httpMessage.addParam("big_refresh_count", i3);
        httpMessage.addParam("fid", this.l);
        httpMessage.addParam("fname", this.m);
        httpMessage.setTag(this.i);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void G(String str, String str2) {
        this.l = str;
        this.m = str2;
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
        MessageManager.getInstance().registerListener(this.o);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.o);
    }
}
