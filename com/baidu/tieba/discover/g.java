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
public class g implements n {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(a aVar) {
        this.a = aVar;
    }

    @Override // com.baidu.tieba.discover.n
    public void a(p pVar) {
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
        bdPullRefreshScrollView = this.a.q;
        bdPullRefreshScrollView.c();
        this.a.r = true;
        bannerView = this.a.e;
        bannerView.a();
        if (pVar.d != null && !TextUtils.isEmpty(pVar.d.b)) {
            bannerView2 = this.a.e;
            bannerView2.a("discover_tab_banner_click", "discover_tab_banner_close");
            bannerView3 = this.a.e;
            bannerView3.b(pVar.d.b, pVar.d.a);
        }
        this.a.s = pVar.e;
        if (pVar.c != null) {
            viewGroup = this.a.d;
            viewGroup.removeAllViews();
            list = this.a.u;
            list.clear();
            int size = pVar.c.size();
            for (int i = 0; i < size; i++) {
                r rVar = pVar.c.get(i);
                baseFragmentActivity = this.a.b;
                DiscoverItemView discoverItemView2 = new DiscoverItemView(baseFragmentActivity);
                DiscoverItemView d = discoverItemView2.a(rVar.a).b(rVar.c).c(rVar.b).a(rVar.d).b(true).d(rVar.c);
                onClickListener = this.a.x;
                d.a(onClickListener);
                if (i == 0) {
                    discoverItemView = this.a.n;
                    discoverItemView.d(false);
                }
                if (i == size - 1) {
                    discoverItemView2.d(true);
                }
                viewGroup2 = this.a.d;
                viewGroup2.addView(discoverItemView2);
                discoverItemView2.d(TbadkApplication.m252getInst().getSkinType());
                list2 = this.a.u;
                list2.add(discoverItemView2);
            }
        }
    }

    @Override // com.baidu.tieba.discover.n
    public void b(p pVar) {
        BdPullRefreshScrollView bdPullRefreshScrollView;
        bdPullRefreshScrollView = this.a.q;
        bdPullRefreshScrollView.c();
        this.a.r = false;
    }
}
