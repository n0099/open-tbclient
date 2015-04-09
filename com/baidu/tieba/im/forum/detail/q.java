package com.baidu.tieba.im.forum.detail;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ ItemFootNavView bdn;
    private final /* synthetic */ ForumDetailActivity bdo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(ItemFootNavView itemFootNavView, ForumDetailActivity forumDetailActivity) {
        this.bdn = itemFootNavView;
        this.bdo = forumDetailActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bdn.d(this.bdo);
    }
}
