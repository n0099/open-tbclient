package com.baidu.tieba.account;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tieba.account.ActivationActivity;
/* loaded from: classes.dex */
class p implements View.OnClickListener {
    final /* synthetic */ ActivationActivity aMw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(ActivationActivity activationActivity) {
        this.aMw = activationActivity;
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
        view2 = this.aMw.ajA;
        if (view != view2) {
            if (view != this.aMw.aMi) {
                if (view != this.aMw.aMj) {
                    imageView = this.aMw.aMd;
                    if (view == imageView) {
                        this.aMw.aMh.setText((CharSequence) null);
                        return;
                    }
                    return;
                } else if (this.aMw.aMm) {
                    bVar = this.aMw.aMk;
                    if (bVar == null) {
                        aVar = this.aMw.aMl;
                        if (aVar == null) {
                            this.aMw.aMk = new ActivationActivity.b(this.aMw, null);
                            bVar2 = this.aMw.aMk;
                            bVar2.setPriority(3);
                            bVar3 = this.aMw.aMk;
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
            aVar2 = this.aMw.aMl;
            if (aVar2 == null) {
                bVar4 = this.aMw.aMk;
                if (bVar4 == null) {
                    this.aMw.aMl = new ActivationActivity.a(this.aMw, null);
                    aVar3 = this.aMw.aMl;
                    aVar3.setPriority(3);
                    aVar4 = this.aMw.aMl;
                    aVar4.execute(new String[0]);
                    return;
                }
                return;
            }
            return;
        }
        this.aMw.setResult(0);
        this.aMw.finish();
    }
}
