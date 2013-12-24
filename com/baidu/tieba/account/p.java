package com.baidu.tieba.account;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
class p implements View.OnClickListener {
    final /* synthetic */ ActivationActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(ActivationActivity activationActivity) {
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
        t tVar;
        s sVar;
        t tVar2;
        t tVar3;
        s sVar2;
        t tVar4;
        s sVar3;
        s sVar4;
        imageView = this.a.b;
        if (view != imageView) {
            relativeLayout = this.a.j;
            if (view == relativeLayout) {
                sVar2 = this.a.m;
                if (sVar2 == null) {
                    tVar4 = this.a.l;
                    if (tVar4 == null) {
                        this.a.m = new s(this.a, null);
                        sVar3 = this.a.m;
                        sVar3.setPriority(3);
                        sVar4 = this.a.m;
                        sVar4.execute(new String[0]);
                        return;
                    }
                    return;
                }
                return;
            }
            relativeLayout2 = this.a.k;
            if (view == relativeLayout2) {
                z = this.a.n;
                if (z) {
                    tVar = this.a.l;
                    if (tVar == null) {
                        sVar = this.a.m;
                        if (sVar == null) {
                            this.a.l = new t(this.a, null);
                            tVar2 = this.a.l;
                            tVar2.setPriority(3);
                            tVar3 = this.a.l;
                            tVar3.execute(new String[0]);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            imageView2 = this.a.d;
            if (view == imageView2) {
                editText = this.a.i;
                editText.setText((CharSequence) null);
                return;
            }
            return;
        }
        this.a.setResult(0);
        this.a.finish();
        com.baidu.tieba.util.be.a("ActivationActivity", "mBack", "onClick");
    }
}
