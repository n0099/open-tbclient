package com.baidu.tieba.discover;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ScrollView.BdPullRefreshScrollView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.view.aa;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
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
    private NoNetworkView n;
    private aa o;
    private BdPullRefreshScrollView p;
    private o r;
    private j u;
    private boolean q = false;
    private List<DiscoverItemView> s = new ArrayList(6);
    private List<DiscoverItemView> t = new ArrayList();
    private com.baidu.adp.widget.ScrollView.m v = new b(this);
    private View.OnClickListener w = new c(this);
    private l x = new d(this);

    private void a() {
        this.c = getView();
        this.n = (NoNetworkView) this.c.findViewById(v.view_no_network);
        f();
        this.o = new aa(this.b);
        this.p = (BdPullRefreshScrollView) this.c.findViewById(v.scroll_view);
        this.p.setCustomHeaderView(this.o);
        this.p.setOnPullDownListener(this.v);
        this.d = (ViewGroup) this.c.findViewById(v.mis_dis_container);
        this.e = (BannerView) this.c.findViewById(v.dis_banner);
        this.f = (DiscoverItemView) this.c.findViewById(v.item_square);
        this.g = (DiscoverItemView) this.c.findViewById(v.item_retie);
        this.h = (DiscoverItemView) this.c.findViewById(v.item_dongtai);
        this.i = (DiscoverItemView) this.c.findViewById(v.item_mylive);
        this.j = (DiscoverItemView) this.c.findViewById(v.item_qiandao);
        this.k = (DiscoverItemView) this.c.findViewById(v.item_qrcode);
        this.l = (DiscoverItemView) this.c.findViewById(v.item_biaoqing);
        this.m = (DiscoverItemView) this.c.findViewById(v.item_tdou);
        this.f.a(u.icon_ba_square).b(y.ba_square).a(this.w).c(false).b();
        this.g.a(u.icon_hot_check).b(y.hot_check).a(this.w);
        this.h.a(u.icon_me_dynamic).b(y.ba_dongtai).a(this.w);
        this.i.a(u.icon_me_live).b(y.discover_item_mylive).a(this.w);
        this.j.a(u.icon_all_sign_dis).b(y.ba_all_sign).a().a(this.w).b();
        this.k.a(u.icon_qr_code_dis).b(y.qrcode).a(this.w);
        this.l.a(u.icon_more_store).b(y.face_store).a().a(this.w).c(DiscoverItemView.e).b();
        this.m.a(u.icon_more_vip).b(y.member_benefits).a(this.w).d(true).a(true).b(true);
        this.s.add(this.f);
        this.s.add(this.g);
        this.s.add(this.h);
        this.s.add(this.i);
        this.s.add(this.j);
        this.s.add(this.k);
        this.s.add(this.l);
        this.s.add(this.m);
    }

    private void f() {
        this.n.a(new e(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.u != null) {
            this.u.a();
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(w.discover_activity, (ViewGroup) null);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.b = (BaseFragmentActivity) activity;
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        a();
        this.u = new j(this.x);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.l.a(TbadkApplication.m252getInst().isFaceShopNew());
    }

    @Override // com.baidu.tbadk.core.d
    public void e() {
        super.e();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2009004, new com.baidu.tbadk.mainTab.a(false)));
        if (!this.q && com.baidu.adp.lib.util.k.d()) {
            this.p.setRefreshing(1);
        }
    }

    @Override // com.baidu.tbadk.core.d
    public void c(int i) {
        super.c(i);
        this.b.a().a(i == 1);
        this.b.a().a(this.c.findViewById(v.container));
        for (DiscoverItemView discoverItemView : this.s) {
            discoverItemView.d(i);
        }
        for (DiscoverItemView discoverItemView2 : this.t) {
            discoverItemView2.d(i);
        }
        this.n.a(i);
        this.o.a(i);
    }
}
