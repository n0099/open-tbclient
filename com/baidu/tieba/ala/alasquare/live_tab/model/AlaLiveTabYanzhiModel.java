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
import d.a.c.e.p.l;
import d.a.c.j.e.n;
import d.a.k0.t.d.c.e.j;
import d.a.k0.t.d.c.g.c;
import java.util.List;
/* loaded from: classes4.dex */
public class AlaLiveTabYanzhiModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f13831e;

    /* renamed from: f  reason: collision with root package name */
    public int f13832f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f13833g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f13834h;
    public c j;
    public long k;
    public String l;
    public String m;
    public b n;
    public HttpMessageListener o = new a(AlaCmdConfigHttp.CMD_ALA_GET_TAB_LIVE_INFO);

    /* renamed from: i  reason: collision with root package name */
    public BdUniqueId f13835i = BdUniqueId.gen();

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021141 && (httpResponsedMessage instanceof AlaTabLiveResponsedMessage) && httpResponsedMessage.getOrginalMessage().getTag() == AlaLiveTabYanzhiModel.this.f13835i) {
                AlaTabLiveResponsedMessage alaTabLiveResponsedMessage = (AlaTabLiveResponsedMessage) httpResponsedMessage;
                if (alaTabLiveResponsedMessage.getError() != 0 || !alaTabLiveResponsedMessage.isSuccess()) {
                    if (AlaLiveTabYanzhiModel.this.n != null) {
                        AlaLiveTabYanzhiModel.this.n.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), AlaLiveTabYanzhiModel.this.f13834h);
                    }
                } else {
                    j jVar = alaTabLiveResponsedMessage.tabAllLiveInfo;
                    if (AlaLiveTabYanzhiModel.this.f13834h) {
                        AlaLiveTabYanzhiModel.this.j.a(jVar);
                        AlaLiveTabYanzhiModel.y(AlaLiveTabYanzhiModel.this);
                    } else {
                        AlaLiveTabFragment.n++;
                        if (AlaLiveTabYanzhiModel.this.j != null) {
                            AlaLiveTabYanzhiModel.this.j.b();
                        }
                        AlaLiveTabYanzhiModel alaLiveTabYanzhiModel = AlaLiveTabYanzhiModel.this;
                        alaLiveTabYanzhiModel.j = new c(jVar, alaLiveTabYanzhiModel.l, AlaLiveTabYanzhiModel.this.m);
                    }
                    AlaLiveTabYanzhiModel alaLiveTabYanzhiModel2 = AlaLiveTabYanzhiModel.this;
                    alaLiveTabYanzhiModel2.f13833g = alaLiveTabYanzhiModel2.j.f();
                    if (AlaLiveTabYanzhiModel.this.n != null) {
                        AlaLiveTabYanzhiModel.this.n.a(AlaLiveTabYanzhiModel.this.f13833g, AlaLiveTabYanzhiModel.this.j.d());
                    }
                }
                AlaLiveTabYanzhiModel.this.f13834h = false;
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(boolean z, List<n> list);

        void b(int i2, String str, boolean z);
    }

    public AlaLiveTabYanzhiModel(TbPageContext tbPageContext, b bVar) {
        this.f13831e = tbPageContext;
        this.n = bVar;
    }

    public static /* synthetic */ int y(AlaLiveTabYanzhiModel alaLiveTabYanzhiModel) {
        int i2 = alaLiveTabYanzhiModel.f13832f;
        alaLiveTabYanzhiModel.f13832f = i2 + 1;
        return i2;
    }

    public void D() {
        if (!this.f13833g || this.f13834h) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.k >= 1800000) {
            this.k = currentTimeMillis;
        }
        this.f13834h = true;
        F(this.f13832f + 1, 1, AlaLiveTabFragment.n - 1);
    }

    public void E() {
        this.k = System.currentTimeMillis();
        this.f13834h = false;
        this.f13832f = 1;
        F(1, 0, AlaLiveTabFragment.n);
    }

    public final void F(int i2, int i3, int i4) {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GET_TAB_LIVE_INFO);
        httpMessage.addParam("tab_id", 2);
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
        httpMessage.addParam("ua_str", l.k(this.f13831e.getPageActivity()) + "_" + l.i(this.f13831e.getPageActivity()) + "_android_" + TbConfig.getVersion());
        httpMessage.addParam(ETAG.KEY_STATISTICS_SEESIONID, this.k);
        httpMessage.addParam("refresh_type", i3);
        httpMessage.addParam("big_refresh_count", i4);
        httpMessage.addParam("fid", this.l);
        httpMessage.addParam("fname", this.m);
        httpMessage.setTag(this.f13835i);
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
