package com.baidu.tieba.account;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tieba.account.ActivationActivity;
/* loaded from: classes.dex */
class l implements View.OnClickListener {
    final /* synthetic */ ActivationActivity aFc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(ActivationActivity activationActivity) {
        this.aFc = activationActivity;
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
        view2 = this.aFc.mBack;
        if (view != view2) {
            if (view != this.aFc.aEP) {
                if (view != this.aFc.aEQ) {
                    imageView = this.aFc.aEK;
                    if (view == imageView) {
                        this.aFc.aEO.setText((CharSequence) null);
                        return;
                    }
                    return;
                } else if (this.aFc.aET) {
                    bVar = this.aFc.aER;
                    if (bVar == null) {
                        aVar = this.aFc.aES;
                        if (aVar == null) {
                            this.aFc.aER = new ActivationActivity.b(this.aFc, null);
                            bVar2 = this.aFc.aER;
                            bVar2.setPriority(3);
                            bVar3 = this.aFc.aER;
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
            aVar2 = this.aFc.aES;
            if (aVar2 == null) {
                bVar4 = this.aFc.aER;
                if (bVar4 == null) {
                    this.aFc.aES = new ActivationActivity.a(this.aFc, null);
                    aVar3 = this.aFc.aES;
                    aVar3.setPriority(3);
                    aVar4 = this.aFc.aES;
                    aVar4.execute(new String[0]);
                    return;
                }
                return;
            }
            return;
        }
        this.aFc.setResult(0);
        this.aFc.finish();
    }
}
