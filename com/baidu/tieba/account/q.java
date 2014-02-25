package com.baidu.tieba.account;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
class q implements View.OnClickListener {
    final /* synthetic */ ActivationActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(ActivationActivity activationActivity) {
        this.a = activationActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ImageView imageView;
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2;
        ImageView imageView2;
        EditText editText;
        boolean z;
        u uVar;
        t tVar;
        u uVar2;
        u uVar3;
        t tVar2;
        u uVar4;
        t tVar3;
        t tVar4;
        imageView = this.a.b;
        if (view != imageView) {
            relativeLayout = this.a.j;
            if (view != relativeLayout) {
                relativeLayout2 = this.a.k;
                if (view != relativeLayout2) {
                    imageView2 = this.a.d;
                    if (view == imageView2) {
                        editText = this.a.i;
                        editText.setText((CharSequence) null);
                        return;
                    }
                    return;
                }
                z = this.a.n;
                if (z) {
                    uVar = this.a.l;
                    if (uVar == null) {
                        tVar = this.a.m;
                        if (tVar == null) {
                            this.a.l = new u(this.a, null);
                            uVar2 = this.a.l;
                            uVar2.setPriority(3);
                            uVar3 = this.a.l;
                            uVar3.execute(new String[0]);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            tVar2 = this.a.m;
            if (tVar2 == null) {
                uVar4 = this.a.l;
                if (uVar4 == null) {
                    this.a.m = new t(this.a, null);
                    tVar3 = this.a.m;
                    tVar3.setPriority(3);
                    tVar4 = this.a.m;
                    tVar4.execute(new String[0]);
                    return;
                }
                return;
            }
            return;
        }
        this.a.setResult(0);
        this.a.finish();
        com.baidu.adp.lib.util.f.a("ActivationActivity", "mBack", "onClick");
    }
}
