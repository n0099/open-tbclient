package com.baidu.tieba.account;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
class e implements View.OnClickListener {
    final /* synthetic */ ActivationActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ActivationActivity activationActivity) {
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
        i iVar;
        h hVar;
        i iVar2;
        i iVar3;
        h hVar2;
        i iVar4;
        h hVar3;
        h hVar4;
        imageView = this.a.b;
        if (view != imageView) {
            relativeLayout = this.a.l;
            if (view != relativeLayout) {
                relativeLayout2 = this.a.m;
                if (view != relativeLayout2) {
                    imageView2 = this.a.d;
                    if (view == imageView2) {
                        editText = this.a.k;
                        editText.setText((CharSequence) null);
                        return;
                    }
                    return;
                }
                z = this.a.p;
                if (z) {
                    iVar = this.a.n;
                    if (iVar == null) {
                        hVar = this.a.o;
                        if (hVar == null) {
                            this.a.n = new i(this.a, null);
                            iVar2 = this.a.n;
                            iVar2.setPriority(3);
                            iVar3 = this.a.n;
                            iVar3.execute(new String[0]);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            hVar2 = this.a.o;
            if (hVar2 == null) {
                iVar4 = this.a.n;
                if (iVar4 == null) {
                    this.a.o = new h(this.a, null);
                    hVar3 = this.a.o;
                    hVar3.setPriority(3);
                    hVar4 = this.a.o;
                    hVar4.execute(new String[0]);
                    return;
                }
                return;
            }
            return;
        }
        this.a.setResult(0);
        this.a.finish();
        com.baidu.tieba.util.z.a("ActivationActivity", "mBack", "onClick");
    }
}
