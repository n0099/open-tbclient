package com.baidu.tieba.account;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tieba.account.ActivationActivity;
/* loaded from: classes.dex */
class q implements View.OnClickListener {
    final /* synthetic */ ActivationActivity aFV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(ActivationActivity activationActivity) {
        this.aFV = activationActivity;
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
        view2 = this.aFV.mBack;
        if (view != view2) {
            if (view != this.aFV.aFI) {
                if (view != this.aFV.aFJ) {
                    imageView = this.aFV.aFD;
                    if (view == imageView) {
                        this.aFV.aFH.setText((CharSequence) null);
                        return;
                    }
                    return;
                } else if (this.aFV.aFM) {
                    bVar = this.aFV.aFK;
                    if (bVar == null) {
                        aVar = this.aFV.aFL;
                        if (aVar == null) {
                            this.aFV.aFK = new ActivationActivity.b(this.aFV, null);
                            bVar2 = this.aFV.aFK;
                            bVar2.setPriority(3);
                            bVar3 = this.aFV.aFK;
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
            aVar2 = this.aFV.aFL;
            if (aVar2 == null) {
                bVar4 = this.aFV.aFK;
                if (bVar4 == null) {
                    this.aFV.aFL = new ActivationActivity.a(this.aFV, null);
                    aVar3 = this.aFV.aFL;
                    aVar3.setPriority(3);
                    aVar4 = this.aFV.aFL;
                    aVar4.execute(new String[0]);
                    return;
                }
                return;
            }
            return;
        }
        this.aFV.setResult(0);
        this.aFV.finish();
    }
}
