package com.baidu.tieba.frs.view;

import android.app.Activity;
import android.view.View;
import com.baidu.tieba.forumdetail.ForumDetailActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    final /* synthetic */ FrsHeaderView aGd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(FrsHeaderView frsHeaderView) {
        this.aGd = frsHeaderView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity activity;
        String str;
        activity = this.aGd.aBP;
        str = this.aGd.mForumId;
        ForumDetailActivity.a(activity, str, ForumDetailActivity.FromType.FRS);
    }
}
