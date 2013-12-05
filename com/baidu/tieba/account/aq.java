package com.baidu.tieba.account;

import android.view.View;
import android.widget.Button;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ReLoginShareActivity f1064a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(ReLoginShareActivity reLoginShareActivity) {
        this.f1064a = reLoginShareActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Button button;
        Button button2;
        button = this.f1064a.d;
        if (view == button) {
            this.f1064a.c();
            return;
        }
        button2 = this.f1064a.c;
        if (view == button2) {
            this.f1064a.d();
        }
    }
}
