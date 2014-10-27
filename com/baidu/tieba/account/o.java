package com.baidu.tieba.account;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
class o implements View.OnClickListener {
    final /* synthetic */ ActivationActivity aeY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(ActivationActivity activationActivity) {
        this.aeY = activationActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2;
        ImageView imageView;
        EditText editText;
        boolean z;
        s sVar;
        r rVar;
        s sVar2;
        s sVar3;
        r rVar2;
        s sVar4;
        r rVar3;
        r rVar4;
        view2 = this.aeY.Js;
        if (view != view2) {
            relativeLayout = this.aeY.aeJ;
            if (view != relativeLayout) {
                relativeLayout2 = this.aeY.aeK;
                if (view != relativeLayout2) {
                    imageView = this.aeY.aeE;
                    if (view == imageView) {
                        editText = this.aeY.aeI;
                        editText.setText((CharSequence) null);
                        return;
                    }
                    return;
                }
                z = this.aeY.aeN;
                if (z) {
                    sVar = this.aeY.aeL;
                    if (sVar == null) {
                        rVar = this.aeY.aeM;
                        if (rVar == null) {
                            this.aeY.aeL = new s(this.aeY, null);
                            sVar2 = this.aeY.aeL;
                            sVar2.setPriority(3);
                            sVar3 = this.aeY.aeL;
                            sVar3.execute(new String[0]);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            rVar2 = this.aeY.aeM;
            if (rVar2 == null) {
                sVar4 = this.aeY.aeL;
                if (sVar4 == null) {
                    this.aeY.aeM = new r(this.aeY, null);
                    rVar3 = this.aeY.aeM;
                    rVar3.setPriority(3);
                    rVar4 = this.aeY.aeM;
                    rVar4.execute(new String[0]);
                    return;
                }
                return;
            }
            return;
        }
        this.aeY.setResult(0);
        this.aeY.finish();
    }
}
