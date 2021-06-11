package com.baidu.tieba.ala.alasquare.special_forum.model;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment;
import com.baidu.tieba.ala.alasquare.special_forum.message.AlaSpecialRecommendResponse;
import com.baidu.webkit.internal.ETAG;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.c.k.e.n;
import d.a.m0.r.q.a2;
import d.a.n0.v.d.f.c.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class SpecialRecommendTabModel extends BdBaseModel {

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f13890f;

    /* renamed from: g  reason: collision with root package name */
    public b f13891g;
    public long j;

    /* renamed from: e  reason: collision with root package name */
    public int f13889e = 1;
    public int k = 60;
    public HttpMessageListener l = new a(AlaCmdConfigHttp.CMD_ALA_SPECIAL_RECOMMEND_TAB);

    /* renamed from: h  reason: collision with root package name */
    public List<n> f13892h = new LinkedList();

    /* renamed from: i  reason: collision with root package name */
    public List<a2> f13893i = new ArrayList();

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            c cVar;
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021095 && (httpResponsedMessage instanceof AlaSpecialRecommendResponse)) {
                AlaSpecialRecommendResponse alaSpecialRecommendResponse = (AlaSpecialRecommendResponse) httpResponsedMessage;
                if (alaSpecialRecommendResponse.isSuccess()) {
                    if (SpecialRecommendTabModel.this.f13889e == 0) {
                        SpecialLiveFragment.Y++;
                        SpecialRecommendTabModel.this.f13892h.clear();
                        SpecialRecommendTabModel.this.f13893i.clear();
                    }
                    boolean z = alaSpecialRecommendResponse.hasMore;
                    if (ListUtils.getCount(alaSpecialRecommendResponse.livesList) > 0) {
                        SpecialRecommendTabModel.this.G(alaSpecialRecommendResponse.livesList);
                    }
                    SpecialRecommendTabModel specialRecommendTabModel = SpecialRecommendTabModel.this;
                    specialRecommendTabModel.D(specialRecommendTabModel.f13893i);
                    if (SpecialRecommendTabModel.this.f13889e == 0 && (cVar = alaSpecialRecommendResponse.mSpecialActivityListData) != null) {
                        SpecialRecommendTabModel.this.E(cVar);
                    }
                    SpecialRecommendTabModel.x(SpecialRecommendTabModel.this);
                    if (SpecialRecommendTabModel.this.f13891g != null) {
                        SpecialRecommendTabModel.this.f13891g.b(SpecialRecommendTabModel.this.f13892h, z);
                    }
                } else if (SpecialRecommendTabModel.this.f13891g != null) {
                    SpecialRecommendTabModel.this.f13891g.a(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(int i2, String str);

        void b(List<n> list, boolean z);
    }

    public SpecialRecommendTabModel(TbPageContext tbPageContext) {
        this.f13890f = tbPageContext;
        MessageManager.getInstance().registerListener(this.l);
    }

    public static /* synthetic */ int x(SpecialRecommendTabModel specialRecommendTabModel) {
        int i2 = specialRecommendTabModel.f13889e;
        specialRecommendTabModel.f13889e = i2 + 1;
        return i2;
    }

    public void D(List<a2> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        this.f13892h = new LinkedList();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2 += 2) {
            d.a.n0.v.d.g.b.b bVar = new d.a.n0.v.d.g.b.b();
            d.a.n0.v.d.a.c cVar = new d.a.n0.v.d.a.c();
            cVar.f65130h = list.get(i2);
            bVar.f65502e = cVar;
            int i3 = i2 + 1;
            if (i3 < size) {
                d.a.n0.v.d.a.c cVar2 = new d.a.n0.v.d.a.c();
                cVar2.f65130h = list.get(i3);
                bVar.f65503f = cVar2;
            }
            this.f13892h.add(bVar);
        }
    }

    public final void E(c cVar) {
        if (cVar == null || ListUtils.isEmpty(cVar.f65434e)) {
            return;
        }
        if (ListUtils.getCount(this.f13892h) > 2) {
            this.f13892h.add(2, cVar);
        } else {
            this.f13892h.add(cVar);
        }
    }

    public final void F(int i2, int i3, int i4) {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_SPECIAL_RECOMMEND_TAB);
        httpMessage.addParam(Config.PACKAGE_NAME, i2);
        httpMessage.addParam("tab_id", 1);
        String str = "N";
        if (j.z()) {
            if (j.H()) {
                str = "1_0";
            } else if (j.v()) {
                str = "0_13";
            } else if (j.u()) {
                str = "0_3";
            } else if (j.t()) {
                str = "0_2";
            }
        }
        httpMessage.addParam("network", str);
        httpMessage.addParam("ua_str", l.k(this.f13890f.getPageActivity()) + "_" + l.i(this.f13890f.getPageActivity()) + "_android_" + TbConfig.getVersion());
        httpMessage.addParam("refresh_type", i3);
        httpMessage.addParam(ETAG.KEY_STATISTICS_SEESIONID, this.j);
        httpMessage.addParam("big_refresh_count", i4);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public final void G(List<a2> list) {
        for (a2 a2Var : list) {
            String z1 = a2Var.z1();
            if (!TextUtils.isEmpty(z1)) {
                boolean z = false;
                Iterator<a2> it = this.f13893i.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (z1.equals(it.next().z1())) {
                            z = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (!z) {
                    this.f13893i.add(a2Var);
                }
            }
        }
    }

    public void H() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.j >= this.k * 30 * 1000) {
            this.j = currentTimeMillis;
        }
        F(this.f13889e, 1, SpecialLiveFragment.Y - 1);
    }

    public void I() {
        this.f13889e = 0;
        this.j = System.currentTimeMillis();
        F(0, 0, SpecialLiveFragment.Y);
    }

    public void J(b bVar) {
        this.f13891g = bVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.l);
    }
}
