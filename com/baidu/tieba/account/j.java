package com.baidu.tieba.account;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
class j implements View.OnClickListener {
    final /* synthetic */ ActivationActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(ActivationActivity activationActivity) {
        this.a = activationActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Button button;
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2;
        ImageView imageView;
        EditText editText;
        boolean z;
        n nVar;
        m mVar;
        n nVar2;
        m mVar2;
        n nVar3;
        m mVar3;
        button = this.a.d;
        if (view != button) {
            relativeLayout = this.a.l;
            if (view != relativeLayout) {
                relativeLayout2 = this.a.m;
                if (view != relativeLayout2) {
                    imageView = this.a.f;
                    if (view == imageView) {
                        editText = this.a.k;
                        editText.setText((CharSequence) null);
                        return;
                    }
                    return;
                }
                z = this.a.p;
                if (z) {
                    nVar = this.a.n;
                    if (nVar == null) {
                        mVar = this.a.o;
                        if (mVar == null) {
                            this.a.n = new n(this.a, null);
                            nVar2 = this.a.n;
                            nVar2.execute(new String[0]);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            mVar2 = this.a.o;
            if (mVar2 == null) {
                nVar3 = this.a.n;
                if (nVar3 == null) {
                    this.a.o = new m(this.a, null);
                    mVar3 = this.a.o;
                    mVar3.execute(new String[0]);
                    return;
                }
                return;
            }
            return;
        }
        this.a.setResult(0);
        this.a.finish();
        com.baidu.tieba.c.ag.a("ActivationActivity", "mBack", "onClick");
    }
}
