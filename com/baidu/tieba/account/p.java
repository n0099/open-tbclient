package com.baidu.tieba.account;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tieba.account.ActivationActivity;
/* loaded from: classes.dex */
class p implements View.OnClickListener {
    final /* synthetic */ ActivationActivity aIw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(ActivationActivity activationActivity) {
        this.aIw = activationActivity;
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
        view2 = this.aIw.mBack;
        if (view != view2) {
            if (view != this.aIw.aIj) {
                if (view != this.aIw.aIk) {
                    imageView = this.aIw.aIe;
                    if (view == imageView) {
                        this.aIw.aIi.setText((CharSequence) null);
                        return;
                    }
                    return;
                } else if (this.aIw.aIn) {
                    bVar = this.aIw.aIl;
                    if (bVar == null) {
                        aVar = this.aIw.aIm;
                        if (aVar == null) {
                            this.aIw.aIl = new ActivationActivity.b(this.aIw, null);
                            bVar2 = this.aIw.aIl;
                            bVar2.setPriority(3);
                            bVar3 = this.aIw.aIl;
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
            aVar2 = this.aIw.aIm;
            if (aVar2 == null) {
                bVar4 = this.aIw.aIl;
                if (bVar4 == null) {
                    this.aIw.aIm = new ActivationActivity.a(this.aIw, null);
                    aVar3 = this.aIw.aIm;
                    aVar3.setPriority(3);
                    aVar4 = this.aIw.aIm;
                    aVar4.execute(new String[0]);
                    return;
                }
                return;
            }
            return;
        }
        this.aIw.setResult(0);
        this.aIw.finish();
    }
}
