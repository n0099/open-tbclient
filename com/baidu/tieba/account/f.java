package com.baidu.tieba.account;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.tieba.util.be;
/* loaded from: classes.dex */
class f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ActivationActivity f1043a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(ActivationActivity activationActivity) {
        this.f1043a = activationActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ImageView imageView;
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2;
        ImageView imageView2;
        EditText editText;
        boolean z;
        j jVar;
        i iVar;
        j jVar2;
        j jVar3;
        i iVar2;
        j jVar4;
        i iVar3;
        i iVar4;
        imageView = this.f1043a.b;
        if (view != imageView) {
            relativeLayout = this.f1043a.l;
            if (view == relativeLayout) {
                iVar2 = this.f1043a.o;
                if (iVar2 == null) {
                    jVar4 = this.f1043a.n;
                    if (jVar4 == null) {
                        this.f1043a.o = new i(this.f1043a, null);
                        iVar3 = this.f1043a.o;
                        iVar3.setPriority(3);
                        iVar4 = this.f1043a.o;
                        iVar4.execute(new String[0]);
                        return;
                    }
                    return;
                }
                return;
            }
            relativeLayout2 = this.f1043a.m;
            if (view == relativeLayout2) {
                z = this.f1043a.p;
                if (z) {
                    jVar = this.f1043a.n;
                    if (jVar == null) {
                        iVar = this.f1043a.o;
                        if (iVar == null) {
                            this.f1043a.n = new j(this.f1043a, null);
                            jVar2 = this.f1043a.n;
                            jVar2.setPriority(3);
                            jVar3 = this.f1043a.n;
                            jVar3.execute(new String[0]);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            imageView2 = this.f1043a.d;
            if (view == imageView2) {
                editText = this.f1043a.k;
                editText.setText((CharSequence) null);
                return;
            }
            return;
        }
        this.f1043a.setResult(0);
        this.f1043a.finish();
        be.a("ActivationActivity", "mBack", "onClick");
    }
}
