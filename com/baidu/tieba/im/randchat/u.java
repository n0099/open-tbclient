package com.baidu.tieba.im.randchat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class u implements View.OnClickListener {
    final /* synthetic */ WaittingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(WaittingActivity waittingActivity) {
        this.a = waittingActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WaittingActivity.f(this.a);
    }
}
