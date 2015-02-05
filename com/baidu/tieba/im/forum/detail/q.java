package com.baidu.tieba.im.forum.detail;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ ItemFootNavView baV;
    private final /* synthetic */ ForumDetailActivity baW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(ItemFootNavView itemFootNavView, ForumDetailActivity forumDetailActivity) {
        this.baV = itemFootNavView;
        this.baW = forumDetailActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.baV.d(this.baW);
    }
}
