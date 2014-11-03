package com.baidu.tieba.flist;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
class y extends com.baidu.adp.base.h {
    final /* synthetic */ ForumRankActivity awY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(ForumRankActivity forumRankActivity) {
        this.awY = forumRankActivity;
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
        this.awY.hideProgressBar();
        bdListView = this.awY.vl;
        bdListView.hN();
        if (obj != null && (obj instanceof ForumRankData)) {
            ForumRankData forumRankData = (ForumRankData) obj;
            if (forumRankData.error_code == 0) {
                if (forumRankData.pic_url != null && forumRankData.pic_url.length() > 0) {
                    z = this.awY.awV;
                    if (z) {
                        bdListView4 = this.awY.vl;
                        tbImageView4 = this.awY.aui;
                        zVar = this.awY.awX;
                        bdListView4.addHeaderView(tbImageView4, zVar, false);
                        this.awY.awV = false;
                    }
                    tbImageView = this.awY.aui;
                    tbImageView.setVisibility(0);
                    tbImageView2 = this.awY.aui;
                    tbImageView2.setTag(forumRankData.pic_url);
                    tbImageView3 = this.awY.aui;
                    ViewGroup.LayoutParams layoutParams = tbImageView3.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = (int) ((com.baidu.adp.lib.util.m.n(this.awY) * 15.0f) / 32.0f);
                    this.awY.awU = forumRankData.pic_url;
                }
                pVar = this.awY.awS;
                pVar.a(forumRankData.forumsquare_list);
                pVar2 = this.awY.awS;
                pVar2.e(Boolean.valueOf(forumRankData.is_order != 0));
                navigationBar = this.awY.mNavigationBar;
                navigationBar.setTitleText(forumRankData.title);
                if (forumRankData.forumsquare_list != null && forumRankData.forumsquare_list.length > 100) {
                    bdListView2 = this.awY.vl;
                    if (((com.baidu.adp.widget.ListView.j) bdListView2.getAdapter()).getFootersCount() <= 0) {
                        bdListView3 = this.awY.vl;
                        linearLayout = this.awY.awA;
                        bdListView3.addFooterView(linearLayout);
                    }
                }
                if (forumRankData.forumsquare_list == null || forumRankData.forumsquare_list.length == 0) {
                    frameLayout = this.awY.awT;
                    frameLayout.setVisibility(0);
                    return;
                }
                frameLayout2 = this.awY.awT;
                frameLayout2.setVisibility(8);
                return;
            } else if (forumRankData.error != null) {
                this.awY.showToast(forumRankData.error.usermsg);
                return;
            } else {
                this.awY.showToast(com.baidu.tieba.y.neterror);
                return;
            }
        }
        this.awY.showToast(com.baidu.tieba.y.neterror);
    }
}
