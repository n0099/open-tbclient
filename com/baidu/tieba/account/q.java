package com.baidu.tieba.account;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
class q implements View.OnClickListener {
    final /* synthetic */ ActivationActivity anq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(ActivationActivity activationActivity) {
        this.anq = activationActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2;
        ImageView imageView;
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
        view2 = this.anq.mBack;
        if (view != view2) {
            relativeLayout = this.anq.anc;
            if (view != relativeLayout) {
                relativeLayout2 = this.anq.and;
                if (view != relativeLayout2) {
                    imageView = this.anq.amX;
                    if (view == imageView) {
                        editText = this.anq.anb;
                        editText.setText((CharSequence) null);
                        return;
                    }
                    return;
                }
                z = this.anq.ang;
                if (z) {
                    uVar = this.anq.ane;
                    if (uVar == null) {
                        tVar = this.anq.anf;
                        if (tVar == null) {
                            this.anq.ane = new u(this.anq, null);
                            uVar2 = this.anq.ane;
                            uVar2.setPriority(3);
                            uVar3 = this.anq.ane;
                            uVar3.execute(new String[0]);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            tVar2 = this.anq.anf;
            if (tVar2 == null) {
                uVar4 = this.anq.ane;
                if (uVar4 == null) {
                    this.anq.anf = new t(this.anq, null);
                    tVar3 = this.anq.anf;
                    tVar3.setPriority(3);
                    tVar4 = this.anq.anf;
                    tVar4.execute(new String[0]);
                    return;
                }
                return;
            }
            return;
        }
        this.anq.setResult(0);
        this.anq.finish();
    }
}
