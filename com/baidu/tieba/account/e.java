package com.baidu.tieba.account;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
class e implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ActivationActivity f876a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ActivationActivity activationActivity) {
        this.f876a = activationActivity;
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
        imageView = this.f876a.b;
        if (view != imageView) {
            relativeLayout = this.f876a.l;
            if (view != relativeLayout) {
                relativeLayout2 = this.f876a.m;
                if (view != relativeLayout2) {
                    imageView2 = this.f876a.d;
                    if (view == imageView2) {
                        editText = this.f876a.k;
                        editText.setText((CharSequence) null);
                        return;
                    }
                    return;
                }
                z = this.f876a.p;
                if (z) {
                    iVar = this.f876a.n;
                    if (iVar == null) {
                        hVar = this.f876a.o;
                        if (hVar == null) {
                            this.f876a.n = new i(this.f876a, null);
                            iVar2 = this.f876a.n;
                            iVar2.setPriority(3);
                            iVar3 = this.f876a.n;
                            iVar3.execute(new String[0]);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            hVar2 = this.f876a.o;
            if (hVar2 == null) {
                iVar4 = this.f876a.n;
                if (iVar4 == null) {
                    this.f876a.o = new h(this.f876a, null);
                    hVar3 = this.f876a.o;
                    hVar3.setPriority(3);
                    hVar4 = this.f876a.o;
                    hVar4.execute(new String[0]);
                    return;
                }
                return;
            }
            return;
        }
        this.f876a.setResult(0);
        this.f876a.finish();
        com.baidu.tieba.util.aj.a("ActivationActivity", "mBack", "onClick");
    }
}
