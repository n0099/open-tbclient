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
import d.a.n0.i0.c;
import d.a.o0.o.e;
import d.a.o0.o.f;
import d.a.o0.z.b0;
import d.a.o0.z.e0.j;
import d.a.o0.z.k;
/* loaded from: classes4.dex */
public class HomePageAlaLiveThreadAdapter extends d.a.c.k.e.a<j, HomePageAlaLiveThreadViewHolder> implements f {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public k o;
    public NEGFeedBackView.b p;
    public String q;
    public b0<j> r;

    /* loaded from: classes4.dex */
    public static class HomePageAlaLiveThreadViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public k f16583a;

        public HomePageAlaLiveThreadViewHolder(k kVar) {
            super(kVar.m());
            this.f16583a = kVar;
        }
    }

    /* loaded from: classes4.dex */
    public class a extends b0<j> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x0106, code lost:
            if (r9.getId() == r8.f16584b.o.M().getId()) goto L15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0127, code lost:
            if (r9.getId() == r8.f16584b.o.N().getId()) goto L15;
         */
        @Override // d.a.o0.z.b0
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
                    HomePageAlaLiveThreadAdapter.this.h0(jVar, view);
                    i2 = 5;
                } else {
                    if (view == HomePageAlaLiveThreadAdapter.this.o.q.getCommentContainer()) {
                        HomePageAlaLiveThreadAdapter.this.h0(jVar, view);
                    } else {
                        if (HomePageAlaLiveThreadAdapter.this.o.M() != null) {
                        }
                        if (HomePageAlaLiveThreadAdapter.this.o.N() != null) {
                        }
                    }
                    i2 = 0;
                }
            } else {
                str = "";
                if (jVar == null || jVar.i() == null) {
                    j = 0;
                    str2 = "";
                } else {
                    i3 = YYLiveUtil.calculateLiveType(jVar.i().s1());
                    String z1 = jVar.i().z1();
                    j = jVar.i().s1().live_id;
                    str = StringUtils.isNull(jVar.i().s1().appId) ? "" : jVar.i().s1().appId;
                    if (jVar.i().s1().mYyExtData != null) {
                        str = TiebaStatic.YYValues.YY_LIVE;
                    }
                    str2 = str;
                    str = z1;
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
                TiebaStaticHelper.addYYParam(statisticItem, jVar.i().s1().mYyExtData);
                TiebaStatic.log(statisticItem);
                i2 = 1;
            }
            if (i2 != 0) {
                d.a.o0.b1.h.m.a.a(jVar.f67302e, HomePageAlaLiveThreadAdapter.this.m, jVar.E(), i2);
            }
        }
    }

    public HomePageAlaLiveThreadAdapter(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.p = null;
        this.r = new a();
        this.n = tbPageContext;
    }

    @Override // d.a.o0.o.f
    public void g(String str) {
        this.q = str;
    }

    public final void h0(j jVar, View view) {
        String str;
        String str2 = "";
        if (jVar == null || jVar.i() == null) {
            str = "";
        } else {
            str2 = jVar.i().z1();
            str = jVar.i().M0();
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
    @Override // d.a.c.k.e.a
    /* renamed from: i0 */
    public HomePageAlaLiveThreadViewHolder Q(ViewGroup viewGroup) {
        k kVar = new k(this.n, this.m);
        this.o = kVar;
        kVar.B(2);
        BdUniqueId bdUniqueId = this.m;
        if (bdUniqueId != null) {
            this.o.V(bdUniqueId);
        }
        return new HomePageAlaLiveThreadViewHolder(this.o);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: j0 */
    public View X(int i2, View view, ViewGroup viewGroup, j jVar, HomePageAlaLiveThreadViewHolder homePageAlaLiveThreadViewHolder) {
        jVar.U(jVar.position + 1);
        k kVar = homePageAlaLiveThreadViewHolder.f16583a;
        if (kVar instanceof e) {
            kVar.setPage(this.q);
        }
        homePageAlaLiveThreadViewHolder.f16583a.Y(i2 + 1);
        homePageAlaLiveThreadViewHolder.f16583a.n(jVar);
        homePageAlaLiveThreadViewHolder.f16583a.p(this.r);
        homePageAlaLiveThreadViewHolder.f16583a.A(this.p);
        if (jVar != null && jVar.i() != null) {
            int calculateLiveType = YYLiveUtil.calculateLiveType(jVar.i().s1());
            String z1 = jVar.i().z1();
            String str = !StringUtils.isNull(jVar.i().s1().appId) ? jVar.i().s1().appId : "";
            if (jVar.i().s1().mYyExtData != null) {
                str = TiebaStatic.YYValues.YY_LIVE;
            }
            long j = jVar.i().s1().live_id;
            StatisticItem statisticItem = new StatisticItem("c11823");
            statisticItem.param("obj_type", calculateLiveType);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, str);
            statisticItem.param("tid", z1);
            statisticItem.param("ab_tag", jVar.z());
            statisticItem.param(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, j);
            statisticItem.param("fid", jVar.i().c0());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("obj_param1", jVar.B());
            statisticItem.param("obj_source", jVar.F());
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, jVar.E());
            TiebaStaticHelper.addYYParam(statisticItem, jVar.i().s1().mYyExtData);
            TiebaStatic.log(statisticItem);
        }
        d.a.o0.b1.h.m.a.c(jVar.f67302e, this.m, jVar.E());
        return homePageAlaLiveThreadViewHolder.a();
    }

    public void k0(NEGFeedBackView.b bVar) {
        this.p = bVar;
    }
}
