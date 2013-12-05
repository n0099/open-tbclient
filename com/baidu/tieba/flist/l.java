package com.baidu.tieba.flist;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ForumListActivity f1306a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(ForumListActivity forumListActivity) {
        this.f1306a = forumListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1306a.d();
    }
}
