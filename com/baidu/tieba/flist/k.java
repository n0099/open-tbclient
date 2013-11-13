package com.baidu.tieba.flist;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ForumListActivity f1253a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(ForumListActivity forumListActivity) {
        this.f1253a = forumListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1253a.b();
    }
}
