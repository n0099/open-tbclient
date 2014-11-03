package com.baidu.tieba.account;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
class o implements View.OnClickListener {
    final /* synthetic */ ActivationActivity afg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(ActivationActivity activationActivity) {
        this.afg = activationActivity;
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
        view2 = this.afg.Jt;
        if (view != view2) {
            relativeLayout = this.afg.aeR;
            if (view != relativeLayout) {
                relativeLayout2 = this.afg.aeS;
                if (view != relativeLayout2) {
                    imageView = this.afg.aeM;
                    if (view == imageView) {
                        editText = this.afg.aeQ;
                        editText.setText((CharSequence) null);
                        return;
                    }
                    return;
                }
                z = this.afg.aeV;
                if (z) {
                    sVar = this.afg.aeT;
                    if (sVar == null) {
                        rVar = this.afg.aeU;
                        if (rVar == null) {
                            this.afg.aeT = new s(this.afg, null);
                            sVar2 = this.afg.aeT;
                            sVar2.setPriority(3);
                            sVar3 = this.afg.aeT;
                            sVar3.execute(new String[0]);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            rVar2 = this.afg.aeU;
            if (rVar2 == null) {
                sVar4 = this.afg.aeT;
                if (sVar4 == null) {
                    this.afg.aeU = new r(this.afg, null);
                    rVar3 = this.afg.aeU;
                    rVar3.setPriority(3);
                    rVar4 = this.afg.aeU;
                    rVar4.execute(new String[0]);
                    return;
                }
                return;
            }
            return;
        }
        this.afg.setResult(0);
        this.afg.finish();
    }
}
