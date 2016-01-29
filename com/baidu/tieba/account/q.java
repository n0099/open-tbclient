package com.baidu.tieba.account;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tieba.account.ActivationActivity;
/* loaded from: classes.dex */
class q implements View.OnClickListener {
    final /* synthetic */ ActivationActivity aJA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(ActivationActivity activationActivity) {
        this.aJA = activationActivity;
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
        view2 = this.aJA.ajk;
        if (view != view2) {
            if (view != this.aJA.aJm) {
                if (view != this.aJA.aJn) {
                    imageView = this.aJA.aJh;
                    if (view == imageView) {
                        this.aJA.aJl.setText((CharSequence) null);
                        return;
                    }
                    return;
                } else if (this.aJA.aJq) {
                    bVar = this.aJA.aJo;
                    if (bVar == null) {
                        aVar = this.aJA.aJp;
                        if (aVar == null) {
                            this.aJA.aJo = new ActivationActivity.b(this.aJA, null);
                            bVar2 = this.aJA.aJo;
                            bVar2.setPriority(3);
                            bVar3 = this.aJA.aJo;
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
            aVar2 = this.aJA.aJp;
            if (aVar2 == null) {
                bVar4 = this.aJA.aJo;
                if (bVar4 == null) {
                    this.aJA.aJp = new ActivationActivity.a(this.aJA, null);
                    aVar3 = this.aJA.aJp;
                    aVar3.setPriority(3);
                    aVar4 = this.aJA.aJp;
                    aVar4.execute(new String[0]);
                    return;
                }
                return;
            }
            return;
        }
        this.aJA.setResult(0);
        this.aJA.finish();
    }
}
