package com.baidu.tieba.discover;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ScrollView.BdPullRefreshScrollView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.coreExtra.view.BannerView;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements l {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.a = aVar;
    }

    @Override // com.baidu.tieba.discover.l
    public void a(n nVar) {
        BdPullRefreshScrollView bdPullRefreshScrollView;
        BannerView bannerView;
        ViewGroup viewGroup;
        List list;
        BaseFragmentActivity baseFragmentActivity;
        View.OnClickListener onClickListener;
        ViewGroup viewGroup2;
        List list2;
        DiscoverItemView discoverItemView;
        BannerView bannerView2;
        BannerView bannerView3;
        bdPullRefreshScrollView = this.a.p;
        bdPullRefreshScrollView.c();
        this.a.q = true;
        bannerView = this.a.e;
        bannerView.b();
        if (nVar.d != null && !TextUtils.isEmpty(nVar.d.b)) {
            bannerView2 = this.a.e;
            bannerView2.a("discover_tab_banner_click", "discover_tab_banner_close");
            bannerView3 = this.a.e;
            bannerView3.b(nVar.d.b, nVar.d.a);
        }
        this.a.r = nVar.e;
        if (nVar.c != null) {
            viewGroup = this.a.d;
            viewGroup.removeAllViews();
            list = this.a.t;
            list.clear();
            int size = nVar.c.size();
            for (int i = 0; i < size; i++) {
                p pVar = nVar.c.get(i);
                baseFragmentActivity = this.a.b;
                DiscoverItemView discoverItemView2 = new DiscoverItemView(baseFragmentActivity);
                DiscoverItemView d = discoverItemView2.a(pVar.a).b(pVar.c).c(pVar.b).a(pVar.d).b(true).d(pVar.c);
                onClickListener = this.a.w;
                d.a(onClickListener);
                if (i == 0) {
                    discoverItemView = this.a.m;
                    discoverItemView.d(false);
                }
                if (i == size - 1) {
                    discoverItemView2.d(true);
                }
                viewGroup2 = this.a.d;
                viewGroup2.addView(discoverItemView2);
                discoverItemView2.d(TbadkApplication.m252getInst().getSkinType());
                list2 = this.a.t;
                list2.add(discoverItemView2);
            }
        }
    }

    @Override // com.baidu.tieba.discover.l
    public void b(n nVar) {
        BdPullRefreshScrollView bdPullRefreshScrollView;
        bdPullRefreshScrollView = this.a.p;
        bdPullRefreshScrollView.c();
        this.a.q = false;
    }
}
