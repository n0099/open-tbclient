package com.baidu.tieba.account;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tieba.account.ActivationActivity;
/* loaded from: classes.dex */
class q implements View.OnClickListener {
    final /* synthetic */ ActivationActivity aEn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(ActivationActivity activationActivity) {
        this.aEn = activationActivity;
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
        view2 = this.aEn.mBack;
        if (view != view2) {
            if (view != this.aEn.aEa) {
                if (view != this.aEn.aEb) {
                    imageView = this.aEn.aDV;
                    if (view == imageView) {
                        this.aEn.aDZ.setText((CharSequence) null);
                        return;
                    }
                    return;
                } else if (this.aEn.aEe) {
                    bVar = this.aEn.aEc;
                    if (bVar == null) {
                        aVar = this.aEn.aEd;
                        if (aVar == null) {
                            this.aEn.aEc = new ActivationActivity.b(this.aEn, null);
                            bVar2 = this.aEn.aEc;
                            bVar2.setPriority(3);
                            bVar3 = this.aEn.aEc;
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
            aVar2 = this.aEn.aEd;
            if (aVar2 == null) {
                bVar4 = this.aEn.aEc;
                if (bVar4 == null) {
                    this.aEn.aEd = new ActivationActivity.a(this.aEn, null);
                    aVar3 = this.aEn.aEd;
                    aVar3.setPriority(3);
                    aVar4 = this.aEn.aEd;
                    aVar4.execute(new String[0]);
                    return;
                }
                return;
            }
            return;
        }
        this.aEn.setResult(0);
        this.aEn.finish();
    }
}
