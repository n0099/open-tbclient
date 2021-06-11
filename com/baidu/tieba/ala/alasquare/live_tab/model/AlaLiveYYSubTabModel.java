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
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment;
import com.baidu.tieba.ala.alasquare.live_tab.message.AlaTabLiveResponsedMessage;
import com.baidu.webkit.internal.ETAG;
import d.a.c.e.p.l;
import d.a.c.k.e.n;
import d.a.n0.v.d.c.e.j;
import d.a.n0.v.d.c.g.d;
import java.util.List;
/* loaded from: classes4.dex */
public class AlaLiveYYSubTabModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f13805e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f13806f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f13807g;

    /* renamed from: i  reason: collision with root package name */
    public d f13809i;
    public long j;
    public int k;
    public String l;
    public String m;
    public b o;
    public int n = 60;
    public HttpMessageListener p = new a(AlaCmdConfigHttp.CMD_ALA_GET_TAB_LIVE_INFO);

    /* renamed from: h  reason: collision with root package name */
    public BdUniqueId f13808h = BdUniqueId.gen();

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021141 && (httpResponsedMessage instanceof AlaTabLiveResponsedMessage) && httpResponsedMessage.getOrginalMessage().getTag() == AlaLiveYYSubTabModel.this.f13808h) {
                AlaTabLiveResponsedMessage alaTabLiveResponsedMessage = (AlaTabLiveResponsedMessage) httpResponsedMessage;
                if (alaTabLiveResponsedMessage.getError() != 0 || !alaTabLiveResponsedMessage.isSuccess()) {
                    if (AlaLiveYYSubTabModel.this.o != null) {
                        AlaLiveYYSubTabModel.this.o.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), AlaLiveYYSubTabModel.this.f13807g);
                    }
                } else {
                    j jVar = alaTabLiveResponsedMessage.tabAllLiveInfo;
                    if (AlaLiveYYSubTabModel.this.f13807g) {
                        AlaLiveYYSubTabModel.this.f13809i.a(jVar);
                    } else {
                        AlaLiveTabFragment.N0(AlaLiveYYSubTabModel.this.k);
                        if (AlaLiveYYSubTabModel.this.f13809i != null) {
                            AlaLiveYYSubTabModel.this.f13809i.b();
                        }
                        AlaLiveYYSubTabModel alaLiveYYSubTabModel = AlaLiveYYSubTabModel.this;
                        alaLiveYYSubTabModel.f13809i = new d(jVar, alaLiveYYSubTabModel.l, AlaLiveYYSubTabModel.this.m);
                    }
                    AlaLiveYYSubTabModel alaLiveYYSubTabModel2 = AlaLiveYYSubTabModel.this;
                    alaLiveYYSubTabModel2.f13806f = alaLiveYYSubTabModel2.f13809i.f();
                    if (AlaLiveYYSubTabModel.this.o != null) {
                        AlaLiveYYSubTabModel.this.o.a(AlaLiveYYSubTabModel.this.f13806f, AlaLiveYYSubTabModel.this.f13809i.d());
                    }
                }
                AlaLiveYYSubTabModel.this.f13807g = false;
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(boolean z, List<n> list);

        void b(int i2, String str, boolean z);
    }

    public AlaLiveYYSubTabModel(TbPageContext tbPageContext, b bVar, int i2) {
        this.f13805e = tbPageContext;
        this.o = bVar;
        this.k = i2;
    }

    public final void H(int i2, int i3) {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GET_TAB_LIVE_INFO);
        httpMessage.addParam("tab_id", this.k);
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
        httpMessage.addParam("ua_str", l.k(this.f13805e.getPageActivity()) + "_" + l.i(this.f13805e.getPageActivity()) + "_android_" + TbConfig.getVersion());
        httpMessage.addParam(ETAG.KEY_STATISTICS_SEESIONID, this.j);
        httpMessage.addParam("refresh_type", i2);
        httpMessage.addParam("big_refresh_count", i3);
        httpMessage.addParam("fid", this.l);
        httpMessage.addParam("fname", this.m);
        httpMessage.setTag(this.f13808h);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void I(String str, String str2) {
        this.l = str;
        this.m = str2;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    public boolean b() {
        d dVar = this.f13809i;
        return (dVar == null || ListUtils.isEmpty(dVar.d())) ? false : true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void init() {
        MessageManager.getInstance().registerListener(this.p);
    }

    public void loadMore() {
        if (!this.f13806f || this.f13807g) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.j >= this.n * 30 * 1000) {
            this.j = currentTimeMillis;
        }
        this.f13807g = true;
        H(1, AlaLiveTabFragment.O0(this.k) - 1);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.p);
    }

    public void refresh() {
        this.j = System.currentTimeMillis();
        this.f13807g = false;
        H(0, AlaLiveTabFragment.O0(this.k));
    }
}
