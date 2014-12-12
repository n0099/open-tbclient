package com.baidu.tieba.account;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
class p implements View.OnClickListener {
    final /* synthetic */ ActivationActivity amw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(ActivationActivity activationActivity) {
        this.amw = activationActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2;
        ImageView imageView;
        EditText editText;
        boolean z;
        t tVar;
        s sVar;
        t tVar2;
        t tVar3;
        s sVar2;
        t tVar4;
        s sVar3;
        s sVar4;
        view2 = this.amw.mBack;
        if (view != view2) {
            relativeLayout = this.amw.ami;
            if (view != relativeLayout) {
                relativeLayout2 = this.amw.amj;
                if (view != relativeLayout2) {
                    imageView = this.amw.amd;
                    if (view == imageView) {
                        editText = this.amw.amh;
                        editText.setText((CharSequence) null);
                        return;
                    }
                    return;
                }
                z = this.amw.amm;
                if (z) {
                    tVar = this.amw.amk;
                    if (tVar == null) {
                        sVar = this.amw.aml;
                        if (sVar == null) {
                            this.amw.amk = new t(this.amw, null);
                            tVar2 = this.amw.amk;
                            tVar2.setPriority(3);
                            tVar3 = this.amw.amk;
                            tVar3.execute(new String[0]);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            sVar2 = this.amw.aml;
            if (sVar2 == null) {
                tVar4 = this.amw.amk;
                if (tVar4 == null) {
                    this.amw.aml = new s(this.amw, null);
                    sVar3 = this.amw.aml;
                    sVar3.setPriority(3);
                    sVar4 = this.amw.aml;
                    sVar4.execute(new String[0]);
                    return;
                }
                return;
            }
            return;
        }
        this.amw.setResult(0);
        this.amw.finish();
    }
}
