package com.baidu.tieba.flist;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
class y extends com.baidu.adp.base.h {
    final /* synthetic */ ForumRankActivity awP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(ForumRankActivity forumRankActivity) {
        this.awP = forumRankActivity;
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
        com.baidu.tbadk.core.util.z zVar;
        this.awP.hideProgressBar();
        bdListView = this.awP.vl;
        bdListView.hN();
        if (obj != null && (obj instanceof ForumRankData)) {
            ForumRankData forumRankData = (ForumRankData) obj;
            if (forumRankData.error_code == 0) {
                if (forumRankData.pic_url != null && forumRankData.pic_url.length() > 0) {
                    z = this.awP.awM;
                    if (z) {
                        bdListView4 = this.awP.vl;
                        tbImageView4 = this.awP.atZ;
                        zVar = this.awP.awO;
                        bdListView4.addHeaderView(tbImageView4, zVar, false);
                        this.awP.awM = false;
                    }
                    tbImageView = this.awP.atZ;
                    tbImageView.setVisibility(0);
                    tbImageView2 = this.awP.atZ;
                    tbImageView2.setTag(forumRankData.pic_url);
                    tbImageView3 = this.awP.atZ;
                    ViewGroup.LayoutParams layoutParams = tbImageView3.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = (int) ((com.baidu.adp.lib.util.m.n(this.awP) * 15.0f) / 32.0f);
                    this.awP.awL = forumRankData.pic_url;
                }
                pVar = this.awP.awJ;
                pVar.a(forumRankData.forumsquare_list);
                pVar2 = this.awP.awJ;
                pVar2.e(Boolean.valueOf(forumRankData.is_order != 0));
                navigationBar = this.awP.mNavigationBar;
                navigationBar.setTitleText(forumRankData.title);
                if (forumRankData.forumsquare_list != null && forumRankData.forumsquare_list.length > 100) {
                    bdListView2 = this.awP.vl;
                    if (((com.baidu.adp.widget.ListView.j) bdListView2.getAdapter()).getFootersCount() <= 0) {
                        bdListView3 = this.awP.vl;
                        linearLayout = this.awP.awr;
                        bdListView3.addFooterView(linearLayout);
                    }
                }
                if (forumRankData.forumsquare_list == null || forumRankData.forumsquare_list.length == 0) {
                    frameLayout = this.awP.awK;
                    frameLayout.setVisibility(0);
                    return;
                }
                frameLayout2 = this.awP.awK;
                frameLayout2.setVisibility(8);
                return;
            } else if (forumRankData.error != null) {
                this.awP.showToast(forumRankData.error.usermsg);
                return;
            } else {
                this.awP.showToast(com.baidu.tieba.y.neterror);
                return;
            }
        }
        this.awP.showToast(com.baidu.tieba.y.neterror);
    }
}
