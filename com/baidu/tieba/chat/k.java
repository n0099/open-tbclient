package com.baidu.tieba.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(a aVar) {
        this.a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.sharedPref.b.a().b("is_shut_down_validate", true);
        this.a.c(false);
        this.a.a(false);
    }
}
