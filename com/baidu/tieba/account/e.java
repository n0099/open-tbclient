package com.baidu.tieba.account;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
class e implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ActivationActivity f878a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ActivationActivity activationActivity) {
        this.f878a = activationActivity;
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
        imageView = this.f878a.b;
        if (view != imageView) {
            relativeLayout = this.f878a.l;
            if (view != relativeLayout) {
                relativeLayout2 = this.f878a.m;
                if (view != relativeLayout2) {
                    imageView2 = this.f878a.d;
                    if (view == imageView2) {
                        editText = this.f878a.k;
                        editText.setText((CharSequence) null);
                        return;
                    }
                    return;
                }
                z = this.f878a.p;
                if (z) {
                    iVar = this.f878a.n;
                    if (iVar == null) {
                        hVar = this.f878a.o;
                        if (hVar == null) {
                            this.f878a.n = new i(this.f878a, null);
                            iVar2 = this.f878a.n;
                            iVar2.setPriority(3);
                            iVar3 = this.f878a.n;
                            iVar3.execute(new String[0]);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            hVar2 = this.f878a.o;
            if (hVar2 == null) {
                iVar4 = this.f878a.n;
                if (iVar4 == null) {
                    this.f878a.o = new h(this.f878a, null);
                    hVar3 = this.f878a.o;
                    hVar3.setPriority(3);
                    hVar4 = this.f878a.o;
                    hVar4.execute(new String[0]);
                    return;
                }
                return;
            }
            return;
        }
        this.f878a.setResult(0);
        this.f878a.finish();
        com.baidu.tieba.util.aj.a("ActivationActivity", "mBack", "onClick");
    }
}
