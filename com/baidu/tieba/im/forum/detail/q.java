package com.baidu.tieba.im.forum.detail;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ ItemFootNavView bcX;
    private final /* synthetic */ ForumDetailActivity bcY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(ItemFootNavView itemFootNavView, ForumDetailActivity forumDetailActivity) {
        this.bcX = itemFootNavView;
        this.bcY = forumDetailActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bcX.d(this.bcY);
    }
}
