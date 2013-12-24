package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av implements View.OnClickListener {
    final /* synthetic */ at a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(at atVar) {
        this.a = atVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.c.a(view, 4, this.a.f, 0L);
    }
}
