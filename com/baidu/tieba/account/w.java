package com.baidu.tieba.account;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
class w implements View.OnClickListener {
    final /* synthetic */ ActivationActivity avm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(ActivationActivity activationActivity) {
        this.avm = activationActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2;
        ImageView imageView;
        EditText editText;
        boolean z;
        aa aaVar;
        z zVar;
        aa aaVar2;
        aa aaVar3;
        z zVar2;
        aa aaVar4;
        z zVar3;
        z zVar4;
        view2 = this.avm.mBack;
        if (view != view2) {
            relativeLayout = this.avm.auY;
            if (view != relativeLayout) {
                relativeLayout2 = this.avm.auZ;
                if (view != relativeLayout2) {
                    imageView = this.avm.auT;
                    if (view == imageView) {
                        editText = this.avm.auX;
                        editText.setText((CharSequence) null);
                        return;
                    }
                    return;
                }
                z = this.avm.avc;
                if (z) {
                    aaVar = this.avm.ava;
                    if (aaVar == null) {
                        zVar = this.avm.avb;
                        if (zVar == null) {
                            this.avm.ava = new aa(this.avm, null);
                            aaVar2 = this.avm.ava;
                            aaVar2.setPriority(3);
                            aaVar3 = this.avm.ava;
                            aaVar3.execute(new String[0]);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            zVar2 = this.avm.avb;
            if (zVar2 == null) {
                aaVar4 = this.avm.ava;
                if (aaVar4 == null) {
                    this.avm.avb = new z(this.avm, null);
                    zVar3 = this.avm.avb;
                    zVar3.setPriority(3);
                    zVar4 = this.avm.avb;
                    zVar4.execute(new String[0]);
                    return;
                }
                return;
            }
            return;
        }
        this.avm.setResult(0);
        this.avm.finish();
    }
}
