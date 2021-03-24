package com.baidu.tieba.homepage.personalize.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import d.b.h0.i0.c;
import d.b.i0.m.e;
import d.b.i0.m.f;
import d.b.i0.x.b0;
import d.b.i0.x.e0.j;
/* loaded from: classes4.dex */
public class HomePageAlaFriendRoomAdapter extends d.b.b.j.e.a<j, HomePageAlaLiveThreadViewHolder> implements f {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public d.b.i0.x.j o;
    public NEGFeedBackView.b p;
    public String q;
    public b0<j> r;

    /* loaded from: classes4.dex */
    public static class HomePageAlaLiveThreadViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public d.b.i0.x.j f17254a;

        public HomePageAlaLiveThreadViewHolder(d.b.i0.x.j jVar) {
            super(jVar.m());
            this.f17254a = jVar;
        }
    }

    /* loaded from: classes4.dex */
    public class a extends b0<j> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0054, code lost:
            if (r4.getId() == r3.f17255b.o.O().getId()) goto L4;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0075, code lost:
            if (r4.getId() == r3.f17255b.o.P().getId()) goto L4;
         */
        @Override // d.b.i0.x.b0
        /* renamed from: d */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(View view, j jVar) {
            int i = 2;
            if (HomePageAlaFriendRoomAdapter.this.o.x == view) {
                i = 1;
            } else if (view == HomePageAlaFriendRoomAdapter.this.o.p.getCommentContainer()) {
                HomePageAlaFriendRoomAdapter.this.j0(jVar, view);
                i = 5;
            } else {
                if (view == HomePageAlaFriendRoomAdapter.this.o.q.getCommentContainer()) {
                    HomePageAlaFriendRoomAdapter.this.j0(jVar, view);
                } else {
                    if (HomePageAlaFriendRoomAdapter.this.o.O() != null) {
                    }
                    if (HomePageAlaFriendRoomAdapter.this.o.P() != null) {
                    }
                }
                i = 0;
            }
            if (i != 0) {
                d.b.i0.z0.g.m.a.a(jVar.f62196e, HomePageAlaFriendRoomAdapter.this.m, jVar.E(), i);
            }
        }
    }

    public HomePageAlaFriendRoomAdapter(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        d.b.i0.x.j jVar = new d.b.i0.x.j(this.n, this.m);
        this.o = jVar;
        jVar.E(2);
        BdUniqueId bdUniqueId = this.m;
        if (bdUniqueId != null) {
            this.o.V(bdUniqueId);
        }
        return new HomePageAlaLiveThreadViewHolder(this.o);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: m0 */
    public View X(int i, View view, ViewGroup viewGroup, j jVar, HomePageAlaLiveThreadViewHolder homePageAlaLiveThreadViewHolder) {
        jVar.U(jVar.position + 1);
        d.b.i0.x.j jVar2 = homePageAlaLiveThreadViewHolder.f17254a;
        if (jVar2 instanceof e) {
            jVar2.setPage(this.q);
        }
        homePageAlaLiveThreadViewHolder.f17254a.X(i + 1);
        homePageAlaLiveThreadViewHolder.f17254a.n(jVar);
        homePageAlaLiveThreadViewHolder.f17254a.q(this.r);
        homePageAlaLiveThreadViewHolder.f17254a.B(this.p);
        d.b.i0.z0.g.m.a.c(jVar.f62196e, this.m, jVar.E());
        if (jVar.n() != null && jVar.n().q1() != null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.ALA_FRIEND_ROOM_CARD_SHOW);
            statisticItem.param("obj_locate", 1);
            statisticItem.param("obj_param1", jVar.n().q1().live_id);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(statisticItem);
        }
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
