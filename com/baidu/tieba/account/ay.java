package com.baidu.tieba.account;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay implements View.OnClickListener {
    final /* synthetic */ ReLoginActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(ReLoginActivity reLoginActivity) {
        this.a = reLoginActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.c();
    }
}
