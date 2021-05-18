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
import d.a.j0.i0.c;
import d.a.k0.m.e;
import d.a.k0.m.f;
import d.a.k0.x.b0;
import d.a.k0.x.e0.j;
/* loaded from: classes4.dex */
public class HomePageAlaFriendRoomAdapter extends d.a.c.j.e.a<j, HomePageAlaLiveThreadViewHolder> implements f {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public d.a.k0.x.j o;
    public NEGFeedBackView.b p;
    public String q;
    public b0<j> r;

    /* loaded from: classes4.dex */
    public static class HomePageAlaLiveThreadViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public d.a.k0.x.j f16526a;

        public HomePageAlaLiveThreadViewHolder(d.a.k0.x.j jVar) {
            super(jVar.l());
            this.f16526a = jVar;
        }
    }

    /* loaded from: classes4.dex */
    public class a extends b0<j> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0054, code lost:
            if (r4.getId() == r3.f16527b.o.L().getId()) goto L4;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0075, code lost:
            if (r4.getId() == r3.f16527b.o.M().getId()) goto L4;
         */
        @Override // d.a.k0.x.b0
        /* renamed from: d */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(View view, j jVar) {
            int i2 = 2;
            if (HomePageAlaFriendRoomAdapter.this.o.x == view) {
                i2 = 1;
            } else if (view == HomePageAlaFriendRoomAdapter.this.o.p.getCommentContainer()) {
                HomePageAlaFriendRoomAdapter.this.g0(jVar, view);
                i2 = 5;
            } else {
                if (view == HomePageAlaFriendRoomAdapter.this.o.q.getCommentContainer()) {
                    HomePageAlaFriendRoomAdapter.this.g0(jVar, view);
                } else {
                    if (HomePageAlaFriendRoomAdapter.this.o.L() != null) {
                    }
                    if (HomePageAlaFriendRoomAdapter.this.o.M() != null) {
                    }
                }
                i2 = 0;
            }
            if (i2 != 0) {
                d.a.k0.a1.g.m.a.a(jVar.f63179e, HomePageAlaFriendRoomAdapter.this.m, jVar.E(), i2);
            }
        }
    }

    public HomePageAlaFriendRoomAdapter(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        d.a.k0.x.j jVar = new d.a.k0.x.j(this.n, this.m);
        this.o = jVar;
        jVar.A(2);
        BdUniqueId bdUniqueId = this.m;
        if (bdUniqueId != null) {
            this.o.S(bdUniqueId);
        }
        return new HomePageAlaLiveThreadViewHolder(this.o);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: i0 */
    public View W(int i2, View view, ViewGroup viewGroup, j jVar, HomePageAlaLiveThreadViewHolder homePageAlaLiveThreadViewHolder) {
        jVar.U(jVar.position + 1);
        d.a.k0.x.j jVar2 = homePageAlaLiveThreadViewHolder.f16526a;
        if (jVar2 instanceof e) {
            jVar2.setPage(this.q);
        }
        homePageAlaLiveThreadViewHolder.f16526a.V(i2 + 1);
        homePageAlaLiveThreadViewHolder.f16526a.m(jVar);
        homePageAlaLiveThreadViewHolder.f16526a.o(this.r);
        homePageAlaLiveThreadViewHolder.f16526a.z(this.p);
        d.a.k0.a1.g.m.a.c(jVar.f63179e, this.m, jVar.E());
        if (jVar.m() != null && jVar.m().q1() != null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.ALA_FRIEND_ROOM_CARD_SHOW);
            statisticItem.param("obj_locate", 1);
            statisticItem.param("obj_param1", jVar.m().q1().live_id);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(statisticItem);
        }
        return homePageAlaLiveThreadViewHolder.a();
    }

    public void j0(NEGFeedBackView.b bVar) {
        this.p = bVar;
    }
}
