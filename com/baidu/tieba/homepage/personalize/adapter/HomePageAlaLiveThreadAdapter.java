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
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import d.a.j0.i0.c;
import d.a.k0.m.e;
import d.a.k0.m.f;
import d.a.k0.x.b0;
import d.a.k0.x.e0.j;
import d.a.k0.x.k;
/* loaded from: classes4.dex */
public class HomePageAlaLiveThreadAdapter extends d.a.c.j.e.a<j, HomePageAlaLiveThreadViewHolder> implements f {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public k o;
    public NEGFeedBackView.b p;
    public String q;
    public b0<j> r;

    /* loaded from: classes4.dex */
    public static class HomePageAlaLiveThreadViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public k f16528a;

        public HomePageAlaLiveThreadViewHolder(k kVar) {
            super(kVar.l());
            this.f16528a = kVar;
        }
    }

    /* loaded from: classes4.dex */
    public class a extends b0<j> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x0106, code lost:
            if (r9.getId() == r8.f16529b.o.L().getId()) goto L15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0127, code lost:
            if (r9.getId() == r8.f16529b.o.M().getId()) goto L15;
         */
        @Override // d.a.k0.x.b0
        /* renamed from: d */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(View view, j jVar) {
            String str;
            long j;
            String str2;
            int i2 = 2;
            int i3 = 0;
            if (HomePageAlaLiveThreadAdapter.this.o.x != view) {
                if (view == HomePageAlaLiveThreadAdapter.this.o.p.getCommentContainer()) {
                    HomePageAlaLiveThreadAdapter.this.g0(jVar, view);
                    i2 = 5;
                } else {
                    if (view == HomePageAlaLiveThreadAdapter.this.o.q.getCommentContainer()) {
                        HomePageAlaLiveThreadAdapter.this.g0(jVar, view);
                    } else {
                        if (HomePageAlaLiveThreadAdapter.this.o.L() != null) {
                        }
                        if (HomePageAlaLiveThreadAdapter.this.o.M() != null) {
                        }
                    }
                    i2 = 0;
                }
            } else {
                str = "";
                if (jVar == null || jVar.m() == null) {
                    j = 0;
                    str2 = "";
                } else {
                    i3 = YYLiveUtil.calculateLiveType(jVar.m().q1());
                    String x1 = jVar.m().x1();
                    j = jVar.m().q1().live_id;
                    str = StringUtils.isNull(jVar.m().q1().appId) ? "" : jVar.m().q1().appId;
                    if (jVar.m().q1().mYyExtData != null) {
                        str = TiebaStatic.YYValues.YY_LIVE;
                    }
                    str2 = str;
                    str = x1;
                }
                StatisticItem statisticItem = new StatisticItem("c11824");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("ab_tag", jVar.z());
                statisticItem.param(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, j);
                statisticItem.param("obj_type", i3);
                statisticItem.param("tid", str);
                statisticItem.param("obj_param1", jVar.B());
                statisticItem.param("obj_source", jVar.F());
                statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, jVar.E());
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, str2);
                TiebaStaticHelper.addYYParam(statisticItem, jVar.m().q1().mYyExtData);
                TiebaStatic.log(statisticItem);
                i2 = 1;
            }
            if (i2 != 0) {
                d.a.k0.a1.g.m.a.a(jVar.f63179e, HomePageAlaLiveThreadAdapter.this.m, jVar.E(), i2);
            }
        }
    }

    public HomePageAlaLiveThreadAdapter(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.p = null;
        this.r = new a();
        this.n = tbPageContext;
    }

    @Override // d.a.k0.m.f
    public void g(String str) {
        this.q = str;
    }

    public final void g0(j jVar, View view) {
        String str;
        String str2 = "";
        if (jVar == null || jVar.m() == null) {
            str = "";
        } else {
            str2 = jVar.m().x1();
            str = jVar.m().L0();
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
    @Override // d.a.c.j.e.a
    /* renamed from: h0 */
    public HomePageAlaLiveThreadViewHolder P(ViewGroup viewGroup) {
        k kVar = new k(this.n, this.m);
        this.o = kVar;
        kVar.A(2);
        BdUniqueId bdUniqueId = this.m;
        if (bdUniqueId != null) {
            this.o.V(bdUniqueId);
        }
        return new HomePageAlaLiveThreadViewHolder(this.o);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: i0 */
    public View W(int i2, View view, ViewGroup viewGroup, j jVar, HomePageAlaLiveThreadViewHolder homePageAlaLiveThreadViewHolder) {
        jVar.U(jVar.position + 1);
        k kVar = homePageAlaLiveThreadViewHolder.f16528a;
        if (kVar instanceof e) {
            kVar.setPage(this.q);
        }
        homePageAlaLiveThreadViewHolder.f16528a.X(i2 + 1);
        homePageAlaLiveThreadViewHolder.f16528a.m(jVar);
        homePageAlaLiveThreadViewHolder.f16528a.o(this.r);
        homePageAlaLiveThreadViewHolder.f16528a.z(this.p);
        if (jVar != null && jVar.m() != null) {
            int calculateLiveType = YYLiveUtil.calculateLiveType(jVar.m().q1());
            String x1 = jVar.m().x1();
            String str = !StringUtils.isNull(jVar.m().q1().appId) ? jVar.m().q1().appId : "";
            if (jVar.m().q1().mYyExtData != null) {
                str = TiebaStatic.YYValues.YY_LIVE;
            }
            long j = jVar.m().q1().live_id;
            StatisticItem statisticItem = new StatisticItem("c11823");
            statisticItem.param("obj_type", calculateLiveType);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, str);
            statisticItem.param("tid", x1);
            statisticItem.param("ab_tag", jVar.z());
            statisticItem.param(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, j);
            statisticItem.param("fid", jVar.m().c0());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("obj_param1", jVar.B());
            statisticItem.param("obj_source", jVar.F());
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, jVar.E());
            TiebaStaticHelper.addYYParam(statisticItem, jVar.m().q1().mYyExtData);
            TiebaStatic.log(statisticItem);
        }
        d.a.k0.a1.g.m.a.c(jVar.f63179e, this.m, jVar.E());
        return homePageAlaLiveThreadViewHolder.a();
    }

    public void j0(NEGFeedBackView.b bVar) {
        this.p = bVar;
    }
}
