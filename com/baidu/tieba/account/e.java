package com.baidu.tieba.account;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
class e implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ActivationActivity f897a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ActivationActivity activationActivity) {
        this.f897a = activationActivity;
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
        imageView = this.f897a.b;
        if (view != imageView) {
            relativeLayout = this.f897a.l;
            if (view != relativeLayout) {
                relativeLayout2 = this.f897a.m;
                if (view != relativeLayout2) {
                    imageView2 = this.f897a.d;
                    if (view == imageView2) {
                        editText = this.f897a.k;
                        editText.setText((CharSequence) null);
                        return;
                    }
                    return;
                }
                z = this.f897a.p;
                if (z) {
                    iVar = this.f897a.n;
                    if (iVar == null) {
                        hVar = this.f897a.o;
                        if (hVar == null) {
                            this.f897a.n = new i(this.f897a, null);
                            iVar2 = this.f897a.n;
                            iVar2.setPriority(3);
                            iVar3 = this.f897a.n;
                            iVar3.execute(new String[0]);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            hVar2 = this.f897a.o;
            if (hVar2 == null) {
                iVar4 = this.f897a.n;
                if (iVar4 == null) {
                    this.f897a.o = new h(this.f897a, null);
                    hVar3 = this.f897a.o;
                    hVar3.setPriority(3);
                    hVar4 = this.f897a.o;
                    hVar4.execute(new String[0]);
                    return;
                }
                return;
            }
            return;
        }
        this.f897a.setResult(0);
        this.f897a.finish();
        com.baidu.tieba.util.aq.a("ActivationActivity", "mBack", "onClick");
    }
}
