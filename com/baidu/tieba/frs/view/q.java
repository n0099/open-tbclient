package com.baidu.tieba.frs.view;

import android.app.Activity;
import android.view.View;
import com.baidu.tieba.forumdetail.ForumDetailActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class q implements View.OnClickListener {
    final /* synthetic */ n a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(n nVar) {
        this.a = nVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Activity activity;
        String str;
        activity = this.a.y;
        str = this.a.A;
        ForumDetailActivity.a(activity, str, ForumDetailActivity.FromType.FRS);
    }
}
