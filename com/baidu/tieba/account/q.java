package com.baidu.tieba.account;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tieba.account.ActivationActivity;
/* loaded from: classes.dex */
class q implements View.OnClickListener {
    final /* synthetic */ ActivationActivity aMd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(ActivationActivity activationActivity) {
        this.aMd = activationActivity;
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
        view2 = this.aMd.afN;
        if (view != view2) {
            if (view != this.aMd.aLP) {
                if (view != this.aMd.aLQ) {
                    imageView = this.aMd.aLK;
                    if (view == imageView) {
                        this.aMd.aLO.setText((CharSequence) null);
                        return;
                    }
                    return;
                } else if (this.aMd.aLT) {
                    bVar = this.aMd.aLR;
                    if (bVar == null) {
                        aVar = this.aMd.aLS;
                        if (aVar == null) {
                            this.aMd.aLR = new ActivationActivity.b(this.aMd, null);
                            bVar2 = this.aMd.aLR;
                            bVar2.setPriority(3);
                            bVar3 = this.aMd.aLR;
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
            aVar2 = this.aMd.aLS;
            if (aVar2 == null) {
                bVar4 = this.aMd.aLR;
                if (bVar4 == null) {
                    this.aMd.aLS = new ActivationActivity.a(this.aMd, null);
                    aVar3 = this.aMd.aLS;
                    aVar3.setPriority(3);
                    aVar4 = this.aMd.aLS;
                    aVar4.execute(new String[0]);
                    return;
                }
                return;
            }
            return;
        }
        this.aMd.setResult(0);
        this.aMd.finish();
    }
}
