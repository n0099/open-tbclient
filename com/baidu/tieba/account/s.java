package com.baidu.tieba.account;

import android.view.View;
import android.widget.ImageView;
/* loaded from: classes.dex */
class s implements View.OnFocusChangeListener {
    final /* synthetic */ ActivationActivity aSr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(ActivationActivity activationActivity) {
        this.aSr = activationActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        ImageView imageView;
        ImageView imageView2;
        if (view == this.aSr.aSc) {
            if (z) {
                imageView2 = this.aSr.aRY;
                imageView2.setVisibility(0);
                return;
            }
            imageView = this.aSr.aRY;
            imageView.setVisibility(8);
        }
    }
}
