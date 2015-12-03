package com.baidu.tieba.account;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tieba.account.ActivationActivity;
/* loaded from: classes.dex */
class o implements View.OnClickListener {
    final /* synthetic */ ActivationActivity aGV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(ActivationActivity activationActivity) {
        this.aGV = activationActivity;
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
        view2 = this.aGV.mBack;
        if (view != view2) {
            if (view != this.aGV.aGI) {
                if (view != this.aGV.aGJ) {
                    imageView = this.aGV.aGD;
                    if (view == imageView) {
                        this.aGV.aGH.setText((CharSequence) null);
                        return;
                    }
                    return;
                } else if (this.aGV.aGM) {
                    bVar = this.aGV.aGK;
                    if (bVar == null) {
                        aVar = this.aGV.aGL;
                        if (aVar == null) {
                            this.aGV.aGK = new ActivationActivity.b(this.aGV, null);
                            bVar2 = this.aGV.aGK;
                            bVar2.setPriority(3);
                            bVar3 = this.aGV.aGK;
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
            aVar2 = this.aGV.aGL;
            if (aVar2 == null) {
                bVar4 = this.aGV.aGK;
                if (bVar4 == null) {
                    this.aGV.aGL = new ActivationActivity.a(this.aGV, null);
                    aVar3 = this.aGV.aGL;
                    aVar3.setPriority(3);
                    aVar4 = this.aGV.aGL;
                    aVar4.execute(new String[0]);
                    return;
                }
                return;
            }
            return;
        }
        this.aGV.setResult(0);
        this.aGV.finish();
    }
}
