package com.baidu.tieba.account;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tieba.account.ActivationActivity;
/* loaded from: classes.dex */
class q implements View.OnClickListener {
    final /* synthetic */ ActivationActivity aMX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(ActivationActivity activationActivity) {
        this.aMX = activationActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        ImageView imageView;
        ActivationActivity.b bVar;
        ActivationActivity.a aVar;
        ActivationActivity.b bVar2;
        ActivationActivity.b bVar3;
        ActivationActivity.a aVar2;
        ActivationActivity.b bVar4;
        ActivationActivity.a aVar3;
        ActivationActivity.a aVar4;
        view2 = this.aMX.agC;
        if (view != view2) {
            if (view != this.aMX.aMJ) {
                if (view != this.aMX.aMK) {
                    imageView = this.aMX.aME;
                    if (view == imageView) {
                        this.aMX.aMI.setText((CharSequence) null);
                        return;
                    }
                    return;
                } else if (this.aMX.aMN) {
                    bVar = this.aMX.aML;
                    if (bVar == null) {
                        aVar = this.aMX.aMM;
                        if (aVar == null) {
                            this.aMX.aML = new ActivationActivity.b(this.aMX, null);
                            bVar2 = this.aMX.aML;
                            bVar2.setPriority(3);
                            bVar3 = this.aMX.aML;
                            bVar3.execute(new String[0]);
                            return;
                        }
                        return;
                    }
                    return;
                } else {
                    return;
                }
            }
            aVar2 = this.aMX.aMM;
            if (aVar2 == null) {
                bVar4 = this.aMX.aML;
                if (bVar4 == null) {
                    this.aMX.aMM = new ActivationActivity.a(this.aMX, null);
                    aVar3 = this.aMX.aMM;
                    aVar3.setPriority(3);
                    aVar4 = this.aMX.aMM;
                    aVar4.execute(new String[0]);
                    return;
                }
                return;
            }
            return;
        }
        this.aMX.setResult(0);
        this.aMX.finish();
    }
}
