package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ci implements View.OnClickListener {
    final /* synthetic */ cd a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ci(cd cdVar) {
        this.a = cdVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.b.a(view, 7, this.a.e, 0L);
    }
}
