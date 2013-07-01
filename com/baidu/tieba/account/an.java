package com.baidu.tieba.account;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
/* loaded from: classes.dex */
class an implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ReLoginShareActivity f651a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(ReLoginShareActivity reLoginShareActivity) {
        this.f651a = reLoginShareActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Button button;
        ImageView imageView;
        Button button2;
        button = this.f651a.e;
        if (view != button) {
            imageView = this.f651a.f;
            if (view != imageView) {
                button2 = this.f651a.d;
                if (view != button2) {
                    return;
                }
                this.f651a.m();
                return;
            }
        }
        this.f651a.d();
    }
}
