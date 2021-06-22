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
import d.a.o0.v.d.c.e.j;
import java.util.List;
/* loaded from: classes4.dex */
public class AlaLiveTabFriendModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f13869e;

    /* renamed from: f  reason: collision with root package name */
    public int f13870f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f13871g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f13872h;
    public d.a.o0.v.d.c.g.a j;
    public long k;
    public b l;
    public HttpMessageListener m = new a(AlaCmdConfigHttp.CMD_ALA_GET_TAB_LIVE_INFO);

    /* renamed from: i  reason: collision with root package name */
    public BdUniqueId f13873i = BdUniqueId.gen();

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021141 && (httpResponsedMessage instanceof AlaTabLiveResponsedMessage) && httpResponsedMessage.getOrginalMessage().getTag() == AlaLiveTabFriendModel.this.f13873i) {
                AlaTabLiveResponsedMessage alaTabLiveResponsedMessage = (AlaTabLiveResponsedMessage) httpResponsedMessage;
                if (alaTabLiveResponsedMessage.getError() != 0 || !alaTabLiveResponsedMessage.isSuccess()) {
                    if (AlaLiveTabFriendModel.this.l != null) {
                        AlaLiveTabFriendModel.this.l.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), AlaLiveTabFriendModel.this.f13872h);
                    }
                } else {
                    j jVar = alaTabLiveResponsedMessage.tabAllLiveInfo;
                    if (AlaLiveTabFriendModel.this.f13872h) {
                        AlaLiveTabFriendModel.this.j.a(jVar);
                        AlaLiveTabFriendModel.C(AlaLiveTabFriendModel.this);
                    } else {
                        AlaLiveTabFragment.o++;
                        if (AlaLiveTabFriendModel.this.j != null) {
                            AlaLiveTabFriendModel.this.j.b();
                        }
                        AlaLiveTabFriendModel.this.j = new d.a.o0.v.d.c.g.a(alaTabLiveResponsedMessage);
                    }
                    AlaLiveTabFriendModel alaLiveTabFriendModel = AlaLiveTabFriendModel.this;
                    alaLiveTabFriendModel.f13871g = alaLiveTabFriendModel.j.f();
                    if (AlaLiveTabFriendModel.this.l != null) {
                        AlaLiveTabFriendModel.this.l.a(AlaLiveTabFriendModel.this.f13871g, AlaLiveTabFriendModel.this.j.d());
                    }
                }
                AlaLiveTabFriendModel.this.f13872h = false;
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(boolean z, List<n> list);

        void b(int i2, String str, boolean z);
    }

    public AlaLiveTabFriendModel(TbPageContext tbPageContext, b bVar) {
        this.f13869e = tbPageContext;
        this.l = bVar;
    }

    public static /* synthetic */ int C(AlaLiveTabFriendModel alaLiveTabFriendModel) {
        int i2 = alaLiveTabFriendModel.f13870f;
        alaLiveTabFriendModel.f13870f = i2 + 1;
        return i2;
    }

    public final void F(int i2, int i3, int i4) {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GET_TAB_LIVE_INFO);
        httpMessage.addParam("tab_id", 3);
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
        httpMessage.addParam("ua_str", l.k(this.f13869e.getPageActivity()) + "_" + l.i(this.f13869e.getPageActivity()) + "_android_" + TbConfig.getVersion());
        httpMessage.addParam(ETAG.KEY_STATISTICS_SEESIONID, this.k);
        httpMessage.addParam("refresh_type", i3);
        httpMessage.addParam("big_refresh_count", i4);
        httpMessage.setTag(this.f13873i);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    public boolean b() {
        d.a.o0.v.d.c.g.a aVar = this.j;
        return (aVar == null || ListUtils.isEmpty(aVar.d())) ? false : true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void init() {
        MessageManager.getInstance().registerListener(this.m);
    }

    public void loadMore() {
        if (!this.f13871g || this.f13872h) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.k >= 1800000) {
            this.k = currentTimeMillis;
        }
        this.f13872h = true;
        F(this.f13870f + 1, 1, AlaLiveTabFragment.o - 1);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.m);
    }

    public void refresh() {
        this.k = System.currentTimeMillis();
        this.f13872h = false;
        this.f13870f = 1;
        F(1, 0, AlaLiveTabFragment.o);
    }
}
