package com.baidu.tieba.account;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
class w implements View.OnClickListener {
    final /* synthetic */ ActivationActivity awW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(ActivationActivity activationActivity) {
        this.awW = activationActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2;
        ImageView imageView;
        EditText editText;
        boolean z;
        ab abVar;
        aa aaVar;
        ab abVar2;
        ab abVar3;
        aa aaVar2;
        ab abVar4;
        aa aaVar3;
        aa aaVar4;
        view2 = this.awW.mBack;
        if (view != view2) {
            relativeLayout = this.awW.awJ;
            if (view != relativeLayout) {
                relativeLayout2 = this.awW.awK;
                if (view != relativeLayout2) {
                    imageView = this.awW.awE;
                    if (view == imageView) {
                        editText = this.awW.awI;
                        editText.setText((CharSequence) null);
                        return;
                    }
                    return;
                }
                z = this.awW.awN;
                if (z) {
                    abVar = this.awW.awL;
                    if (abVar == null) {
                        aaVar = this.awW.awM;
                        if (aaVar == null) {
                            this.awW.awL = new ab(this.awW, null);
                            abVar2 = this.awW.awL;
                            abVar2.setPriority(3);
                            abVar3 = this.awW.awL;
                            abVar3.execute(new String[0]);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            aaVar2 = this.awW.awM;
            if (aaVar2 == null) {
                abVar4 = this.awW.awL;
                if (abVar4 == null) {
                    this.awW.awM = new aa(this.awW, null);
                    aaVar3 = this.awW.awM;
                    aaVar3.setPriority(3);
                    aaVar4 = this.awW.awM;
                    aaVar4.execute(new String[0]);
                    return;
                }
                return;
            }
            return;
        }
        this.awW.setResult(0);
        this.awW.finish();
    }
}
