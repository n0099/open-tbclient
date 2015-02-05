package com.baidu.tieba.account;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
class q implements View.OnClickListener {
    final /* synthetic */ ActivationActivity ann;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(ActivationActivity activationActivity) {
        this.ann = activationActivity;
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
        view2 = this.ann.mBack;
        if (view != view2) {
            relativeLayout = this.ann.amZ;
            if (view != relativeLayout) {
                relativeLayout2 = this.ann.ana;
                if (view != relativeLayout2) {
                    imageView = this.ann.amU;
                    if (view == imageView) {
                        editText = this.ann.amY;
                        editText.setText((CharSequence) null);
                        return;
                    }
                    return;
                }
                z = this.ann.and;
                if (z) {
                    uVar = this.ann.anb;
                    if (uVar == null) {
                        tVar = this.ann.anc;
                        if (tVar == null) {
                            this.ann.anb = new u(this.ann, null);
                            uVar2 = this.ann.anb;
                            uVar2.setPriority(3);
                            uVar3 = this.ann.anb;
                            uVar3.execute(new String[0]);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            tVar2 = this.ann.anc;
            if (tVar2 == null) {
                uVar4 = this.ann.anb;
                if (uVar4 == null) {
                    this.ann.anc = new t(this.ann, null);
                    tVar3 = this.ann.anc;
                    tVar3.setPriority(3);
                    tVar4 = this.ann.anc;
                    tVar4.execute(new String[0]);
                    return;
                }
                return;
            }
            return;
        }
        this.ann.setResult(0);
        this.ann.finish();
    }
}
