package com.baidu.tieba.im.randchat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ WaittingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(WaittingActivity waittingActivity) {
        this.a = waittingActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.d();
    }
}
