package com.baidu.tieba.im.forum.detail;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    private final /* synthetic */ ForumDetailActivity aZA;
    final /* synthetic */ ItemFootNavView aZz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(ItemFootNavView itemFootNavView, ForumDetailActivity forumDetailActivity) {
        this.aZz = itemFootNavView;
        this.aZA = forumDetailActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aZz.d(this.aZA);
    }
}
