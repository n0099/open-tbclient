package com.baidu.tieba.flist;

import android.os.Handler;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
class aa extends com.baidu.adp.base.g {
    final /* synthetic */ ForumRankActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(ForumRankActivity forumRankActivity) {
        this.a = forumRankActivity;
    }

    @Override // com.baidu.adp.base.g
    public void a(Object obj) {
        BdListView bdListView;
        r rVar;
        r rVar2;
        NavigationBar navigationBar;
        FrameLayout frameLayout;
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        FrameLayout frameLayout2;
        BdListView bdListView2;
        BdListView bdListView3;
        LinearLayout linearLayout;
        boolean z;
        TbImageView tbImageView;
        TbImageView tbImageView2;
        TbImageView tbImageView3;
        BdListView bdListView4;
        TbImageView tbImageView4;
        com.baidu.tbadk.core.util.ad adVar;
        this.a.hideProgressBar();
        bdListView = this.a.a;
        bdListView.c();
        if (obj != null && (obj instanceof ForumRankData)) {
            ForumRankData forumRankData = (ForumRankData) obj;
            if (forumRankData.error != null && forumRankData.error.errno == 0) {
                if (forumRankData.pic_url != null && forumRankData.pic_url.length() > 0) {
                    z = this.a.m;
                    if (z) {
                        bdListView4 = this.a.a;
                        tbImageView4 = this.a.e;
                        adVar = this.a.o;
                        bdListView4.addHeaderView(tbImageView4, adVar, false);
                        this.a.m = false;
                    }
                    tbImageView = this.a.e;
                    tbImageView.setVisibility(0);
                    tbImageView2 = this.a.e;
                    tbImageView2.setTag(forumRankData.pic_url);
                    tbImageView3 = this.a.e;
                    ViewGroup.LayoutParams layoutParams = tbImageView3.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = (int) ((com.baidu.adp.lib.util.h.b(this.a) * 15.0f) / 32.0f);
                    this.a.l = forumRankData.pic_url;
                }
                rVar = this.a.c;
                rVar.a(forumRankData.forumsquare_list);
                rVar2 = this.a.c;
                rVar2.a(Boolean.valueOf(forumRankData.is_order != 0));
                navigationBar = this.a.d;
                navigationBar.a(forumRankData.title);
                if (forumRankData.forumsquare_list != null && forumRankData.forumsquare_list.length > 100) {
                    bdListView2 = this.a.a;
                    if (((com.baidu.adp.widget.ListView.g) bdListView2.getAdapter()).d() <= 0) {
                        bdListView3 = this.a.a;
                        linearLayout = this.a.h;
                        bdListView3.addFooterView(linearLayout);
                    }
                }
                if (forumRankData.forumsquare_list == null || forumRankData.forumsquare_list.length == 0) {
                    frameLayout = this.a.j;
                    frameLayout.setVisibility(0);
                } else {
                    frameLayout2 = this.a.j;
                    frameLayout2.setVisibility(8);
                }
                handler = this.a.k;
                runnable = this.a.q;
                handler.removeCallbacks(runnable);
                handler2 = this.a.k;
                runnable2 = this.a.q;
                handler2.postDelayed(runnable2, 0L);
                return;
            } else if (forumRankData.error != null) {
                this.a.showToast(forumRankData.error.usermsg);
                return;
            } else {
                this.a.showToast(com.baidu.tieba.u.neterror);
                return;
            }
        }
        this.a.showToast(com.baidu.tieba.u.neterror);
    }
}
