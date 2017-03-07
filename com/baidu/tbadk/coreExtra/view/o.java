package com.baidu.tbadk.coreExtra.view;

import android.view.View;
import android.widget.Button;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ MultiImageView atX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(MultiImageView multiImageView) {
        this.atX = multiImageView;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001c, code lost:
        r0 = r1.atX.getCurrentImageView();
     */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        Button button;
        Button button2;
        com.baidu.tbadk.widget.a currentImageView;
        com.baidu.tbadk.widget.a currentImageView2;
        button = this.atX.atN;
        if (view != button) {
            button2 = this.atX.atO;
            if (view == button2 && currentImageView != null) {
                currentImageView.Hk();
                return;
            }
            return;
        }
        currentImageView2 = this.atX.getCurrentImageView();
        if (currentImageView2 != null) {
            currentImageView2.Hj();
        }
    }
}
