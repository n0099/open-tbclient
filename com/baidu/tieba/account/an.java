package com.baidu.tieba.account;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
/* loaded from: classes.dex */
class an implements View.OnClickListener {
    final /* synthetic */ ReLoginShareActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(ReLoginShareActivity reLoginShareActivity) {
        this.a = reLoginShareActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Button button;
        ImageView imageView;
        Button button2;
        button = this.a.g;
        if (view != button) {
            imageView = this.a.h;
            if (view != imageView) {
                button2 = this.a.f;
                if (view != button2) {
                    return;
                }
                this.a.m();
                return;
            }
        }
        this.a.d();
    }
}
