package com.baidu.tieba.frs.view;

import android.app.Activity;
import android.view.View;
import com.baidu.tieba.forumdetail.ForumDetailActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements View.OnClickListener {
    final /* synthetic */ r aGu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(r rVar) {
        this.aGu = rVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity activity;
        String str;
        activity = this.aGu.aBP;
        str = this.aGu.mForumId;
        ForumDetailActivity.a(activity, str, ForumDetailActivity.FromType.FRS);
    }
}
