package com.baidu.tieba.discover;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ScrollView.BdPullRefreshScrollView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tieba.view.z;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class a extends com.baidu.tbadk.core.d {
    private com.baidu.tbadk.core.e b;
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
    private NoNetworkView m;
    private z n;
    private BdPullRefreshScrollView o;
    private o q;
    private j t;
    private boolean p = false;
    private List<DiscoverItemView> r = new ArrayList(6);
    private List<DiscoverItemView> s = new ArrayList();
    private com.baidu.adp.widget.ScrollView.m u = new b(this);
    private View.OnClickListener v = new c(this);
    private l w = new d(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(a aVar) {
        if (aVar.t != null) {
            aVar.t.a();
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(com.baidu.tieba.a.i.discover_activity, (ViewGroup) null);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onAttach(Activity activity) {
        super.onAttach(activity);
        this.b = (com.baidu.tbadk.core.e) activity;
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.c = getView();
        this.m = (NoNetworkView) this.c.findViewById(com.baidu.tieba.a.h.view_no_network);
        this.m.a(new e(this));
        this.n = new z(this.b);
        this.o = (BdPullRefreshScrollView) this.c.findViewById(com.baidu.tieba.a.h.scroll_view);
        this.o.setCustomHeaderView(this.n);
        this.o.setOnPullDownListener(this.u);
        this.d = (ViewGroup) this.c.findViewById(com.baidu.tieba.a.h.mis_dis_container);
        this.e = (BannerView) this.c.findViewById(com.baidu.tieba.a.h.dis_banner);
        this.f = (DiscoverItemView) this.c.findViewById(com.baidu.tieba.a.h.item_square);
        this.g = (DiscoverItemView) this.c.findViewById(com.baidu.tieba.a.h.item_retie);
        this.h = (DiscoverItemView) this.c.findViewById(com.baidu.tieba.a.h.item_dongtai);
        this.i = (DiscoverItemView) this.c.findViewById(com.baidu.tieba.a.h.item_qiandao);
        this.j = (DiscoverItemView) this.c.findViewById(com.baidu.tieba.a.h.item_qrcode);
        this.k = (DiscoverItemView) this.c.findViewById(com.baidu.tieba.a.h.item_biaoqing);
        this.l = (DiscoverItemView) this.c.findViewById(com.baidu.tieba.a.h.item_tdou);
        this.f.a(com.baidu.tieba.a.g.icon_ba_square).b(com.baidu.tieba.a.k.ba_square).a(this.v).c(false).b();
        this.g.a(com.baidu.tieba.a.g.icon_hot_check).b(com.baidu.tieba.a.k.hot_check).a(this.v);
        this.h.a(com.baidu.tieba.a.g.icon_me_dynamic).b(com.baidu.tieba.a.k.ba_dongtai).a(this.v);
        this.i.a(com.baidu.tieba.a.g.icon_all_sign_dis).b(com.baidu.tieba.a.k.ba_all_sign).a().a(this.v).b();
        this.j.a(com.baidu.tieba.a.g.icon_qr_code_dis).b(com.baidu.tieba.a.k.qrcode).a(this.v);
        this.k.a(com.baidu.tieba.a.g.icon_more_store).b(com.baidu.tieba.a.k.face_store).a().a(this.v).c(DiscoverItemView.e).b();
        this.l.a(com.baidu.tieba.a.g.icon_more_vip).b(com.baidu.tieba.a.k.member_benefits).a(this.v).d(true).a(true).b(true);
        this.r.add(this.f);
        this.r.add(this.g);
        this.r.add(this.h);
        this.r.add(this.i);
        this.r.add(this.j);
        this.r.add(this.k);
        this.r.add(this.l);
        this.t = new j(this.w);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onResume() {
        super.onResume();
        this.k.a(TbadkApplication.j().ae());
    }

    @Override // com.baidu.tbadk.core.d
    public final void d() {
        super.d();
        com.baidu.adp.framework.c.a().a(new CustomResponsedMessage(2007004, new com.baidu.tbadk.mainTab.a(false)));
        if (!this.p) {
            this.o.setRefreshing(1);
        }
    }

    @Override // com.baidu.tbadk.core.d
    public final void c(int i) {
        super.c(i);
        this.b.b().a(i == 1);
        this.b.b().a(this.c.findViewById(com.baidu.tieba.a.h.container));
        for (DiscoverItemView discoverItemView : this.r) {
            discoverItemView.d(i);
        }
        for (DiscoverItemView discoverItemView2 : this.s) {
            discoverItemView2.d(i);
        }
        this.m.a(i);
        this.n.a(i);
    }
}
