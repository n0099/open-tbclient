package com.baidu.tieba.im.forum.detail;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ ItemFootNavView baW;
    private final /* synthetic */ ForumDetailActivity baX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(ItemFootNavView itemFootNavView, ForumDetailActivity forumDetailActivity) {
        this.baW = itemFootNavView;
        this.baX = forumDetailActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.baW.d(this.baX);
    }
}
