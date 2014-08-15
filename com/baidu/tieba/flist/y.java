package com.baidu.tieba.flist;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
class y extends com.baidu.adp.base.h {
    final /* synthetic */ ForumRankActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(ForumRankActivity forumRankActivity) {
        this.a = forumRankActivity;
    }

    @Override // com.baidu.adp.base.h
    public void a(Object obj) {
        BdListView bdListView;
        p pVar;
        p pVar2;
        NavigationBar navigationBar;
        FrameLayout frameLayout;
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
        com.baidu.tbadk.core.util.aa aaVar;
        this.a.hideProgressBar();
        bdListView = this.a.a;
        bdListView.d();
        if (obj != null && (obj instanceof ForumRankData)) {
            ForumRankData forumRankData = (ForumRankData) obj;
            if (forumRankData.error != null && forumRankData.error.errno == 0) {
                if (forumRankData.pic_url != null && forumRankData.pic_url.length() > 0) {
                    z = this.a.k;
                    if (z) {
                        bdListView4 = this.a.a;
                        tbImageView4 = this.a.e;
                        aaVar = this.a.m;
                        bdListView4.addHeaderView(tbImageView4, aaVar, false);
                        this.a.k = false;
                    }
                    tbImageView = this.a.e;
                    tbImageView.setVisibility(0);
                    tbImageView2 = this.a.e;
                    tbImageView2.setTag(forumRankData.pic_url);
                    tbImageView3 = this.a.e;
                    ViewGroup.LayoutParams layoutParams = tbImageView3.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = (int) ((com.baidu.adp.lib.util.j.b(this.a) * 15.0f) / 32.0f);
                    this.a.j = forumRankData.pic_url;
                }
                pVar = this.a.c;
                pVar.a(forumRankData.forumsquare_list);
                pVar2 = this.a.c;
                pVar2.a(Boolean.valueOf(forumRankData.is_order != 0));
                navigationBar = this.a.d;
                navigationBar.a(forumRankData.title);
                if (forumRankData.forumsquare_list != null && forumRankData.forumsquare_list.length > 100) {
                    bdListView2 = this.a.a;
                    if (((com.baidu.adp.widget.ListView.g) bdListView2.getAdapter()).d() <= 0) {
                        bdListView3 = this.a.a;
                        linearLayout = this.a.g;
                        bdListView3.addFooterView(linearLayout);
                    }
                }
                if (forumRankData.forumsquare_list == null || forumRankData.forumsquare_list.length == 0) {
                    frameLayout = this.a.i;
                    frameLayout.setVisibility(0);
                    return;
                }
                frameLayout2 = this.a.i;
                frameLayout2.setVisibility(8);
                return;
            } else if (forumRankData.error != null) {
                this.a.showToast(forumRankData.error.usermsg);
                return;
            } else {
                this.a.showToast(com.baidu.tieba.x.neterror);
                return;
            }
        }
        this.a.showToast(com.baidu.tieba.x.neterror);
    }
}
