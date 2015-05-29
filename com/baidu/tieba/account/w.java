package com.baidu.tieba.account;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
class w implements View.OnClickListener {
    final /* synthetic */ ActivationActivity awV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(ActivationActivity activationActivity) {
        this.awV = activationActivity;
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
        view2 = this.awV.mBack;
        if (view != view2) {
            relativeLayout = this.awV.awI;
            if (view != relativeLayout) {
                relativeLayout2 = this.awV.awJ;
                if (view != relativeLayout2) {
                    imageView = this.awV.awD;
                    if (view == imageView) {
                        editText = this.awV.awH;
                        editText.setText((CharSequence) null);
                        return;
                    }
                    return;
                }
                z = this.awV.awM;
                if (z) {
                    abVar = this.awV.awK;
                    if (abVar == null) {
                        aaVar = this.awV.awL;
                        if (aaVar == null) {
                            this.awV.awK = new ab(this.awV, null);
                            abVar2 = this.awV.awK;
                            abVar2.setPriority(3);
                            abVar3 = this.awV.awK;
                            abVar3.execute(new String[0]);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            aaVar2 = this.awV.awL;
            if (aaVar2 == null) {
                abVar4 = this.awV.awK;
                if (abVar4 == null) {
                    this.awV.awL = new aa(this.awV, null);
                    aaVar3 = this.awV.awL;
                    aaVar3.setPriority(3);
                    aaVar4 = this.awV.awL;
                    aaVar4.execute(new String[0]);
                    return;
                }
                return;
            }
            return;
        }
        this.awV.setResult(0);
        this.awV.finish();
    }
}
