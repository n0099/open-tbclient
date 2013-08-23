package com.baidu.tieba.flist;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ForumListActivity f1045a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(ForumListActivity forumListActivity) {
        this.f1045a = forumListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1045a.c();
    }
}
