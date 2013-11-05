package com.baidu.tieba.account;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ReLoginShareActivity f1028a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(ReLoginShareActivity reLoginShareActivity) {
        this.f1028a = reLoginShareActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Button button;
        ImageView imageView;
        Button button2;
        button = this.f1028a.e;
        if (view != button) {
            imageView = this.f1028a.f;
            if (view != imageView) {
                button2 = this.f1028a.d;
                if (view == button2) {
                    this.f1028a.e();
                    return;
                }
                return;
            }
        }
        this.f1028a.d();
    }
}
