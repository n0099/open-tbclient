package com.baidu.tieba.account;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
/* loaded from: classes.dex */
class ao implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ReLoginShareActivity f882a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(ReLoginShareActivity reLoginShareActivity) {
        this.f882a = reLoginShareActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Button button;
        ImageView imageView;
        Button button2;
        button = this.f882a.e;
        if (view != button) {
            imageView = this.f882a.f;
            if (view != imageView) {
                button2 = this.f882a.d;
                if (view != button2) {
                    return;
                }
                this.f882a.k();
                return;
            }
        }
        this.f882a.d();
    }
}
