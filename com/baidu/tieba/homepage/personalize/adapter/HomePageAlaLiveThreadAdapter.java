package com.baidu.tieba.homepage.personalize.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.ala.atomdata.AlaSDKShareEmptyActivityConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import d.b.h0.i0.c;
import d.b.i0.m.e;
import d.b.i0.m.f;
import d.b.i0.x.b0;
import d.b.i0.x.e0.j;
import d.b.i0.x.k;
/* loaded from: classes4.dex */
public class HomePageAlaLiveThreadAdapter extends d.b.b.j.e.a<j, HomePageAlaLiveThreadViewHolder> implements f {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public k o;
    public NEGFeedBackView.b p;
    public String q;
    public b0<j> r;

    /* loaded from: classes4.dex */
    public static class HomePageAlaLiveThreadViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public k f17256a;

        public HomePageAlaLiveThreadViewHolder(k kVar) {
            super(kVar.m());
            this.f17256a = kVar;
        }
    }

    /* loaded from: classes4.dex */
    public class a extends b0<j> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x00c4, code lost:
            if (r7.getId() == r6.f17257b.o.O().getId()) goto L9;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x00e5, code lost:
            if (r7.getId() == r6.f17257b.o.P().getId()) goto L9;
         */
        @Override // d.b.i0.x.b0
        /* renamed from: d */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(View view, j jVar) {
            String str;
            int i = 2;
            int i2 = 0;
            if (HomePageAlaLiveThreadAdapter.this.o.x != view) {
                if (view == HomePageAlaLiveThreadAdapter.this.o.p.getCommentContainer()) {
                    HomePageAlaLiveThreadAdapter.this.j0(jVar, view);
                    i = 5;
                } else {
                    if (view == HomePageAlaLiveThreadAdapter.this.o.q.getCommentContainer()) {
                        HomePageAlaLiveThreadAdapter.this.j0(jVar, view);
                    } else {
                        if (HomePageAlaLiveThreadAdapter.this.o.O() != null) {
                        }
                        if (HomePageAlaLiveThreadAdapter.this.o.P() != null) {
                        }
                    }
                    i = 0;
                }
            } else {
                long j = 0;
                if (jVar == null || jVar.n() == null) {
                    str = "";
                } else {
                    i2 = jVar.n().q1().live_type;
                    str = jVar.n().w1();
                    j = jVar.n().q1().live_id;
                }
                StatisticItem statisticItem = new StatisticItem("c11824");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("ab_tag", jVar.z());
                statisticItem.param(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, j);
                statisticItem.param("obj_type", i2);
                statisticItem.param("tid", str);
                statisticItem.param("obj_param1", jVar.B());
                statisticItem.param("obj_source", jVar.F());
                statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, jVar.E());
                TiebaStatic.log(statisticItem);
                i = 1;
            }
            if (i != 0) {
                d.b.i0.z0.g.m.a.a(jVar.f62196e, HomePageAlaLiveThreadAdapter.this.m, jVar.E(), i);
            }
        }
    }

    public HomePageAlaLiveThreadAdapter(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.p = null;
        this.r = new a();
        this.n = tbPageContext;
    }

    public final void j0(j jVar, View view) {
        String str;
        String str2 = "";
        if (jVar == null || jVar.n() == null) {
            str = "";
        } else {
            str2 = jVar.n().w1();
            str = jVar.n().L0();
        }
        StatisticItem statisticItem = new StatisticItem("c12942");
        statisticItem.param("obj_locate", 1);
        statisticItem.param("obj_type", 5);
        statisticItem.param("tid", str2);
        statisticItem.param("obj_source", jVar.F());
        statisticItem.param("nid", str);
        c f2 = TbPageExtraHelper.f(view);
        if (f2 != null) {
            statisticItem.param(TiebaStatic.Params.OBJ_CUR_PAGE, f2.a());
        }
        if (TbPageExtraHelper.m() != null) {
            statisticItem.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.m());
        }
        TiebaStatic.log(statisticItem);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: l0 */
    public HomePageAlaLiveThreadViewHolder R(ViewGroup viewGroup) {
        k kVar = new k(this.n, this.m);
        this.o = kVar;
        kVar.E(2);
        BdUniqueId bdUniqueId = this.m;
        if (bdUniqueId != null) {
            this.o.W(bdUniqueId);
        }
        return new HomePageAlaLiveThreadViewHolder(this.o);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: m0 */
    public View X(int i, View view, ViewGroup viewGroup, j jVar, HomePageAlaLiveThreadViewHolder homePageAlaLiveThreadViewHolder) {
        jVar.U(jVar.position + 1);
        k kVar = homePageAlaLiveThreadViewHolder.f17256a;
        if (kVar instanceof e) {
            kVar.setPage(this.q);
        }
        homePageAlaLiveThreadViewHolder.f17256a.Y(i + 1);
        homePageAlaLiveThreadViewHolder.f17256a.n(jVar);
        homePageAlaLiveThreadViewHolder.f17256a.q(this.r);
        homePageAlaLiveThreadViewHolder.f17256a.B(this.p);
        if (jVar != null && jVar.n() != null) {
            int i2 = jVar.n().q1().live_type;
            String w1 = jVar.n().w1();
            String str = !StringUtils.isNull(jVar.n().q1().appId) ? jVar.n().q1().appId : "";
            long j = jVar.n().q1().live_id;
            StatisticItem statisticItem = new StatisticItem("c11823");
            statisticItem.param("obj_type", i2);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, str);
            statisticItem.param("tid", w1);
            statisticItem.param("ab_tag", jVar.z());
            statisticItem.param(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, j);
            statisticItem.param("fid", jVar.n().c0());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("obj_param1", jVar.B());
            statisticItem.param("obj_source", jVar.F());
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, jVar.E());
            TiebaStatic.log(statisticItem);
        }
        d.b.i0.z0.g.m.a.c(jVar.f62196e, this.m, jVar.E());
        return homePageAlaLiveThreadViewHolder.a();
    }

    public void n0(NEGFeedBackView.b bVar) {
        this.p = bVar;
    }

    @Override // d.b.i0.m.f
    public void o(String str) {
        this.q = str;
    }
}
