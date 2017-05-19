package com.baidu.tbadk.coreExtra.view;

import android.view.View;
import android.widget.Button;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ MultiImageView aut;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(MultiImageView multiImageView) {
        this.aut = multiImageView;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001c, code lost:
        r0 = r1.aut.getCurrentImageView();
     */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        Button button;
        Button button2;
        com.baidu.tbadk.widget.b currentImageView;
        com.baidu.tbadk.widget.b currentImageView2;
        button = this.aut.auj;
        if (view != button) {
            button2 = this.aut.auk;
            if (view == button2 && currentImageView != null) {
                currentImageView.GU();
                return;
            }
            return;
        }
        currentImageView2 = this.aut.getCurrentImageView();
        if (currentImageView2 != null) {
            currentImageView2.GT();
        }
    }
}
