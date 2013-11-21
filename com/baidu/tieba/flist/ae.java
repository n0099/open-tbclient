package com.baidu.tieba.flist;

import android.content.Context;
import android.os.Handler;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae extends com.baidu.adp.a.g {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ForumRankActivity f1245a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ForumRankActivity forumRankActivity) {
        this.f1245a = forumRankActivity;
    }

    @Override // com.baidu.adp.a.g
    public void a(Object obj) {
        BdListView bdListView;
        s sVar;
        s sVar2;
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
        com.baidu.tieba.util.i iVar;
        BdListView bdListView4;
        TbImageView tbImageView4;
        this.f1245a.hideProgressBar();
        bdListView = this.f1245a.f1239a;
        bdListView.a();
        if (obj != null && (obj instanceof ForumRankData)) {
            ForumRankData forumRankData = (ForumRankData) obj;
            if (forumRankData.error != null && forumRankData.error.errno == 0) {
                if (forumRankData.pic_url != null && forumRankData.pic_url.length() > 0) {
                    z = this.f1245a.m;
                    if (z) {
                        bdListView4 = this.f1245a.f1239a;
                        tbImageView4 = this.f1245a.e;
                        bdListView4.addHeaderView(tbImageView4, null, false);
                        this.f1245a.m = false;
                    }
                    tbImageView = this.f1245a.e;
                    tbImageView.setVisibility(0);
                    tbImageView2 = this.f1245a.e;
                    tbImageView2.setTag(forumRankData.pic_url);
                    tbImageView3 = this.f1245a.e;
                    ViewGroup.LayoutParams layoutParams = tbImageView3.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = (int) ((UtilHelper.a((Context) this.f1245a) * 15.0f) / 32.0f);
                    iVar = this.f1245a.f;
                    iVar.a(forumRankData.pic_url, new af(this));
                }
                sVar = this.f1245a.c;
                sVar.a(forumRankData.forumsquare_list);
                sVar2 = this.f1245a.c;
                sVar2.a(Boolean.valueOf(forumRankData.is_order != 0));
                navigationBar = this.f1245a.d;
                navigationBar.a(forumRankData.title);
                if (forumRankData.forumsquare_list != null && forumRankData.forumsquare_list.length > 100) {
                    bdListView2 = this.f1245a.f1239a;
                    if (((com.baidu.adp.widget.ListView.e) bdListView2.getAdapter()).d() <= 0) {
                        bdListView3 = this.f1245a.f1239a;
                        linearLayout = this.f1245a.h;
                        bdListView3.addFooterView(linearLayout);
                    }
                }
                if (forumRankData.forumsquare_list == null || forumRankData.forumsquare_list.length == 0) {
                    frameLayout = this.f1245a.j;
                    frameLayout.setVisibility(0);
                } else {
                    frameLayout2 = this.f1245a.j;
                    frameLayout2.setVisibility(8);
                }
                handler = this.f1245a.l;
                runnable = this.f1245a.p;
                handler.removeCallbacks(runnable);
                handler2 = this.f1245a.l;
                runnable2 = this.f1245a.p;
                handler2.postDelayed(runnable2, 0L);
                return;
            } else if (forumRankData.error != null) {
                this.f1245a.showToast(forumRankData.error.usermsg);
                return;
            } else {
                this.f1245a.showToast(R.string.neterror);
                return;
            }
        }
        this.f1245a.showToast(R.string.neterror);
    }
}
