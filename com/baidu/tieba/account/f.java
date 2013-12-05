package com.baidu.tieba.account;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.tieba.util.bd;
/* loaded from: classes.dex */
class f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ActivationActivity f1078a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(ActivationActivity activationActivity) {
        this.f1078a = activationActivity;
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
        imageView = this.f1078a.b;
        if (view != imageView) {
            relativeLayout = this.f1078a.j;
            if (view == relativeLayout) {
                iVar2 = this.f1078a.m;
                if (iVar2 == null) {
                    jVar4 = this.f1078a.l;
                    if (jVar4 == null) {
                        this.f1078a.m = new i(this.f1078a, null);
                        iVar3 = this.f1078a.m;
                        iVar3.setPriority(3);
                        iVar4 = this.f1078a.m;
                        iVar4.execute(new String[0]);
                        return;
                    }
                    return;
                }
                return;
            }
            relativeLayout2 = this.f1078a.k;
            if (view == relativeLayout2) {
                z = this.f1078a.n;
                if (z) {
                    jVar = this.f1078a.l;
                    if (jVar == null) {
                        iVar = this.f1078a.m;
                        if (iVar == null) {
                            this.f1078a.l = new j(this.f1078a, null);
                            jVar2 = this.f1078a.l;
                            jVar2.setPriority(3);
                            jVar3 = this.f1078a.l;
                            jVar3.execute(new String[0]);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            imageView2 = this.f1078a.d;
            if (view == imageView2) {
                editText = this.f1078a.i;
                editText.setText((CharSequence) null);
                return;
            }
            return;
        }
        this.f1078a.setResult(0);
        this.f1078a.finish();
        bd.a("ActivationActivity", "mBack", "onClick");
    }
}
