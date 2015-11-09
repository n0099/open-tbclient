package com.baidu.tieba.account;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tieba.account.ActivationActivity;
/* loaded from: classes.dex */
class l implements View.OnClickListener {
    final /* synthetic */ ActivationActivity aDW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(ActivationActivity activationActivity) {
        this.aDW = activationActivity;
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
        view2 = this.aDW.mBack;
        if (view != view2) {
            if (view != this.aDW.aDJ) {
                if (view != this.aDW.aDK) {
                    imageView = this.aDW.aDE;
                    if (view == imageView) {
                        this.aDW.aDI.setText((CharSequence) null);
                        return;
                    }
                    return;
                } else if (this.aDW.aDN) {
                    bVar = this.aDW.aDL;
                    if (bVar == null) {
                        aVar = this.aDW.aDM;
                        if (aVar == null) {
                            this.aDW.aDL = new ActivationActivity.b(this.aDW, null);
                            bVar2 = this.aDW.aDL;
                            bVar2.setPriority(3);
                            bVar3 = this.aDW.aDL;
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
            aVar2 = this.aDW.aDM;
            if (aVar2 == null) {
                bVar4 = this.aDW.aDL;
                if (bVar4 == null) {
                    this.aDW.aDM = new ActivationActivity.a(this.aDW, null);
                    aVar3 = this.aDW.aDM;
                    aVar3.setPriority(3);
                    aVar4 = this.aDW.aDM;
                    aVar4.execute(new String[0]);
                    return;
                }
                return;
            }
            return;
        }
        this.aDW.setResult(0);
        this.aDW.finish();
    }
}
