package com.baidu.tieba.discover;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ScrollView.BdPullRefreshScrollView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.coreExtra.view.BannerView;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d implements l {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.a = aVar;
    }

    @Override // com.baidu.tieba.discover.l
    public final void a(n nVar) {
        BdPullRefreshScrollView bdPullRefreshScrollView;
        ViewGroup viewGroup;
        List list;
        com.baidu.tbadk.core.e eVar;
        View.OnClickListener onClickListener;
        ViewGroup viewGroup2;
        List list2;
        DiscoverItemView discoverItemView;
        BannerView bannerView;
        BannerView bannerView2;
        bdPullRefreshScrollView = this.a.o;
        bdPullRefreshScrollView.a();
        this.a.p = true;
        if (nVar.d != null && !TextUtils.isEmpty(nVar.d.b)) {
            bannerView = this.a.e;
            bannerView.a("discover_tab_banner_click", "discover_tab_banner_close");
            bannerView2 = this.a.e;
            bannerView2.a(nVar.d.b, nVar.d.a, "discover_banner_date", 259200000L);
        }
        this.a.q = nVar.e;
        if (nVar.c != null) {
            viewGroup = this.a.d;
            viewGroup.removeAllViews();
            list = this.a.s;
            list.clear();
            int size = nVar.c.size();
            for (int i = 0; i < size; i++) {
                p pVar = nVar.c.get(i);
                eVar = this.a.b;
                DiscoverItemView discoverItemView2 = new DiscoverItemView(eVar);
                DiscoverItemView d = discoverItemView2.a(pVar.a).b(pVar.c).c(pVar.b).a(pVar.d).b(true).d(pVar.c);
                onClickListener = this.a.v;
                d.a(onClickListener);
                if (i == 0) {
                    discoverItemView = this.a.l;
                    discoverItemView.d(false);
                }
                if (i == size - 1) {
                    discoverItemView2.d(true);
                }
                viewGroup2 = this.a.d;
                viewGroup2.addView(discoverItemView2);
                discoverItemView2.d(TbadkApplication.j().l());
                list2 = this.a.s;
                list2.add(discoverItemView2);
            }
        }
    }

    @Override // com.baidu.tieba.discover.l
    public final void a() {
        BdPullRefreshScrollView bdPullRefreshScrollView;
        bdPullRefreshScrollView = this.a.o;
        bdPullRefreshScrollView.a();
        this.a.p = false;
    }
}
