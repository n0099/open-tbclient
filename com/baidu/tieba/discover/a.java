package com.baidu.tieba.discover;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.n;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.view.BannerView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class a extends com.baidu.tbadk.core.d {
    private com.baidu.tbadk.core.e a;
    private View b;
    private ViewGroup c;
    private BannerView d;
    private DiscoverItemView e;
    private DiscoverItemView f;
    private DiscoverItemView g;
    private DiscoverItemView h;
    private DiscoverItemView i;
    private DiscoverItemView j;
    private DiscoverItemView k;
    private NoNetworkView l;
    private k n;
    private boolean m = false;
    private List<DiscoverItemView> o = new ArrayList(6);
    private List<DiscoverItemView> p = new ArrayList();
    private View.OnClickListener q = new b(this);
    private com.baidu.adp.framework.c.b r = new c(this, 1004000);

    /* JADX INFO: Access modifiers changed from: private */
    public static void a() {
        HttpMessage httpMessage = new HttpMessage(1004000);
        httpMessage.b(1004000);
        com.baidu.adp.framework.c.a().a(httpMessage);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(com.baidu.tieba.a.i.discover_activity, (ViewGroup) null);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onAttach(Activity activity) {
        super.onAttach(activity);
        this.a = (com.baidu.tbadk.core.e) activity;
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.b = getView();
        this.l = (NoNetworkView) this.b.findViewById(com.baidu.tieba.a.h.view_no_network);
        this.l.a(new d(this));
        this.c = (ViewGroup) this.b.findViewById(com.baidu.tieba.a.h.mis_dis_container);
        this.d = (BannerView) this.b.findViewById(com.baidu.tieba.a.h.dis_banner);
        this.e = (DiscoverItemView) this.b.findViewById(com.baidu.tieba.a.h.item_square);
        this.f = (DiscoverItemView) this.b.findViewById(com.baidu.tieba.a.h.item_retie);
        this.g = (DiscoverItemView) this.b.findViewById(com.baidu.tieba.a.h.item_dongtai);
        this.h = (DiscoverItemView) this.b.findViewById(com.baidu.tieba.a.h.item_qiandao);
        this.i = (DiscoverItemView) this.b.findViewById(com.baidu.tieba.a.h.item_qrcode);
        this.j = (DiscoverItemView) this.b.findViewById(com.baidu.tieba.a.h.item_biaoqing);
        this.k = (DiscoverItemView) this.b.findViewById(com.baidu.tieba.a.h.item_tdou);
        this.e.a(com.baidu.tieba.a.g.icon_ba_square).b(com.baidu.tieba.a.k.ba_square).a(this.q).b();
        this.f.a(com.baidu.tieba.a.g.icon_hot_check).b(com.baidu.tieba.a.k.hot_check).a(this.q);
        this.g.a(com.baidu.tieba.a.g.icon_me_dynamic).b(com.baidu.tieba.a.k.ba_dongtai).a().a(this.q);
        this.h.a(com.baidu.tieba.a.g.icon_all_sign_dis).b(com.baidu.tieba.a.k.ba_all_sign).a(this.q).b();
        this.i.a(com.baidu.tieba.a.g.icon_qr_code_dis).b(com.baidu.tieba.a.k.qrcode).a().a(this.q);
        this.j.a(com.baidu.tieba.a.g.icon_more_store).b(com.baidu.tieba.a.k.face_store).a(this.q).a(TbadkApplication.j().ac()).c(DiscoverItemView.e).b();
        this.k.a(com.baidu.tieba.a.g.icon_more_vip).b(com.baidu.tieba.a.k.member_benefits).a(this.q).a(true).b(true);
        this.o.add(this.e);
        this.o.add(this.f);
        this.o.add(this.g);
        this.o.add(this.h);
        this.o.add(this.i);
        this.o.add(this.j);
        this.o.add(this.k);
        com.baidu.adp.framework.c a = com.baidu.adp.framework.c.a();
        com.baidu.tbadk.c.b bVar = new com.baidu.tbadk.c.b(1004000, String.valueOf(n.a) + "c/s/found");
        bVar.a(DiscoverResponsedMessage.class);
        a.a(bVar);
        a.a(this.r);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onResume() {
        super.onResume();
        this.j.a(TbadkApplication.j().ac());
        com.baidu.adp.framework.c.a().a(new CustomResponsedMessage(2007004, new com.baidu.tbadk.mainTab.a(TbadkApplication.j().ac())));
    }

    @Override // com.baidu.tbadk.core.d
    public final void onPrimary() {
        super.onPrimary();
        if (!this.m) {
            a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(a aVar, j jVar) {
        aVar.m = true;
        if (jVar.d != null && !TextUtils.isEmpty(jVar.d.b)) {
            aVar.d.a("discover_tab_banner_click", "discover_tab_banner_close");
            aVar.d.a(jVar.d.b, jVar.d.a, "discover_banner_date", 259200000L);
        }
        aVar.n = jVar.e;
        if (jVar.c != null) {
            aVar.c.removeAllViews();
            aVar.p.clear();
            int size = jVar.c.size();
            for (int i = 0; i < size; i++) {
                l lVar = jVar.c.get(i);
                DiscoverItemView discoverItemView = new DiscoverItemView(aVar.a);
                discoverItemView.a(lVar.a).b(lVar.c).c(lVar.b).a(lVar.d).b(true).d(lVar.c).a(aVar.q);
                if (i == size - 1) {
                    discoverItemView.a();
                }
                aVar.c.addView(discoverItemView);
                discoverItemView.d(TbadkApplication.j().l());
                aVar.p.add(discoverItemView);
            }
        }
    }

    @Override // com.baidu.tbadk.core.d
    public final void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.a.b().a(i == 1);
        this.a.b().a(this.b.findViewById(com.baidu.tieba.a.h.container));
        for (DiscoverItemView discoverItemView : this.o) {
            discoverItemView.d(i);
        }
        for (DiscoverItemView discoverItemView2 : this.p) {
            discoverItemView2.d(i);
        }
        this.l.a(i);
    }
}
