package com.baidu.tieba.discover;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ScrollView.BdPullRefreshScrollView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tieba.view.z;
import com.baidu.tieba.x;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.core.d {
    private BaseFragmentActivity b;
    private View c;
    private ViewGroup d;
    private BannerView e;
    private DiscoverItemView f;
    private DiscoverItemView g;
    private DiscoverItemView h;
    private DiscoverItemView i;
    private DiscoverItemView j;
    private DiscoverItemView k;
    private DiscoverItemView l;
    private DiscoverItemView m;
    private DiscoverItemView n;
    private NoNetworkView o;
    private z p;
    private BdPullRefreshScrollView q;
    private q s;
    private l v;
    private boolean r = false;
    private List<DiscoverItemView> t = new ArrayList(6);
    private List<DiscoverItemView> u = new ArrayList();
    private com.baidu.adp.widget.ScrollView.m w = new b(this);
    private View.OnClickListener x = new c(this);
    private com.baidu.tbadk.core.dialog.d y = new d(this);
    private com.baidu.tbadk.core.dialog.d z = new e(this);
    private CustomMessageListener A = new f(this, 2012118);
    private n B = new g(this);

    private void a() {
        this.c = getView();
        this.o = (NoNetworkView) this.c.findViewById(com.baidu.tieba.u.view_no_network);
        g();
        this.p = new z(this.b);
        this.q = (BdPullRefreshScrollView) this.c.findViewById(com.baidu.tieba.u.scroll_view);
        this.q.setCustomHeaderView(this.p);
        this.q.setOnPullDownListener(this.w);
        this.d = (ViewGroup) this.c.findViewById(com.baidu.tieba.u.mis_dis_container);
        this.e = (BannerView) this.c.findViewById(com.baidu.tieba.u.dis_banner);
        this.f = (DiscoverItemView) this.c.findViewById(com.baidu.tieba.u.item_friendsnews);
        this.g = (DiscoverItemView) this.c.findViewById(com.baidu.tieba.u.item_quanbarebo);
        this.h = (DiscoverItemView) this.c.findViewById(com.baidu.tieba.u.item_findqunzu);
        this.i = (DiscoverItemView) this.c.findViewById(com.baidu.tieba.u.item_neighbors);
        this.j = (DiscoverItemView) this.c.findViewById(com.baidu.tieba.u.item_laiyifa);
        this.k = (DiscoverItemView) this.c.findViewById(com.baidu.tieba.u.item_square);
        this.l = (DiscoverItemView) this.c.findViewById(com.baidu.tieba.u.item_qiandao);
        this.m = (DiscoverItemView) this.c.findViewById(com.baidu.tieba.u.item_biaoqing);
        this.n = (DiscoverItemView) this.c.findViewById(com.baidu.tieba.u.item_tdou);
        this.f.a(com.baidu.tieba.t.icon_friendsnews).b(x.friendsnews).a(this.x).c(DiscoverItemView.f).a(TbadkApplication.m252getInst().isFriendFeedNew()).b(false).c(false);
        this.g.a(com.baidu.tieba.t.icon_live_telecast).b(x.quanbarebo).a(this.x).a();
        this.h.a(com.baidu.tieba.t.icon_group).b(x.faxianqunzu).a(this.x);
        this.i.a(com.baidu.tieba.t.icon_neighbors).b(x.neighbors).a(this.x);
        this.j.a(com.baidu.tieba.t.icon_come_chat).b(x.laiyifa).a(this.x);
        this.k.a(com.baidu.tieba.t.icon_ba_square).b(x.square).a(this.x);
        this.l.a(com.baidu.tieba.t.icon_all_sign_dis).b(x.ba_all_sign).a(this.x);
        this.m.a(com.baidu.tieba.t.icon_more_store).b(x.face_store).a(this.x).a(true).b(true).a();
        this.n.a(com.baidu.tieba.t.icon_member_center).b(x.member_center).a(this.x).d(true).a(true).b(true);
        this.t.add(this.k);
        this.t.add(this.j);
        this.t.add(this.f);
        this.t.add(this.h);
        this.t.add(this.i);
        this.t.add(this.l);
        this.t.add(this.g);
        this.t.add(this.m);
        this.t.add(this.n);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.b);
        aVar.b(x.warning_location_switch_off).a(x.isopen, this.y).b(x.cancel, this.z).a();
        aVar.b();
    }

    private void g() {
        this.o.a(new h(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.v != null) {
            this.v.a();
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(com.baidu.tieba.v.discover_activity, (ViewGroup) null);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.b = (BaseFragmentActivity) activity;
        MessageManager.getInstance().registerListener(this.A);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        MessageManager.getInstance().unRegisterListener(this.A);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        a();
        this.v = new l(this.B);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.m.a(TbadkApplication.m252getInst().isFaceShopNew());
        this.f.a(TbadkApplication.m252getInst().isFriendFeedNew());
    }

    @Override // com.baidu.tbadk.core.d
    public void e() {
        super.e();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007004, new com.baidu.tbadk.mainTab.a(false)));
        if (!this.r && com.baidu.adp.lib.util.j.c()) {
            this.q.setRefreshing(1);
            com.baidu.tbadk.core.f.b(this.b, "found_ck");
        }
    }

    @Override // com.baidu.tbadk.core.d
    public void c(int i) {
        super.c(i);
        this.b.c().a(i == 1);
        this.b.c().a(this.c.findViewById(com.baidu.tieba.u.container));
        for (DiscoverItemView discoverItemView : this.t) {
            discoverItemView.d(i);
        }
        for (DiscoverItemView discoverItemView2 : this.u) {
            discoverItemView2.d(i);
        }
        this.o.a(i);
        this.p.a(i);
    }
}
