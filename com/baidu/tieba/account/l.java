package com.baidu.tieba.account;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tieba.account.ActivationActivity;
/* loaded from: classes.dex */
class l implements View.OnClickListener {
    final /* synthetic */ ActivationActivity aER;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(ActivationActivity activationActivity) {
        this.aER = activationActivity;
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
        view2 = this.aER.mBack;
        if (view != view2) {
            if (view != this.aER.aEE) {
                if (view != this.aER.aEF) {
                    imageView = this.aER.aEz;
                    if (view == imageView) {
                        this.aER.aED.setText((CharSequence) null);
                        return;
                    }
                    return;
                } else if (this.aER.aEI) {
                    bVar = this.aER.aEG;
                    if (bVar == null) {
                        aVar = this.aER.aEH;
                        if (aVar == null) {
                            this.aER.aEG = new ActivationActivity.b(this.aER, null);
                            bVar2 = this.aER.aEG;
                            bVar2.setPriority(3);
                            bVar3 = this.aER.aEG;
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
            aVar2 = this.aER.aEH;
            if (aVar2 == null) {
                bVar4 = this.aER.aEG;
                if (bVar4 == null) {
                    this.aER.aEH = new ActivationActivity.a(this.aER, null);
                    aVar3 = this.aER.aEH;
                    aVar3.setPriority(3);
                    aVar4 = this.aER.aEH;
                    aVar4.execute(new String[0]);
                    return;
                }
                return;
            }
            return;
        }
        this.aER.setResult(0);
        this.aER.finish();
    }
}
