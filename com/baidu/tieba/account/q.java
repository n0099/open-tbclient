package com.baidu.tieba.account;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tieba.account.ActivationActivity;
/* loaded from: classes.dex */
class q implements View.OnClickListener {
    final /* synthetic */ ActivationActivity aSr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(ActivationActivity activationActivity) {
        this.aSr = activationActivity;
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
        view2 = this.aSr.ajw;
        if (view != view2) {
            if (view != this.aSr.aSd) {
                if (view != this.aSr.aSe) {
                    imageView = this.aSr.aRY;
                    if (view == imageView) {
                        this.aSr.aSc.setText((CharSequence) null);
                        return;
                    }
                    return;
                } else if (this.aSr.aSh) {
                    bVar = this.aSr.aSf;
                    if (bVar == null) {
                        aVar = this.aSr.aSg;
                        if (aVar == null) {
                            this.aSr.aSf = new ActivationActivity.b(this.aSr, null);
                            bVar2 = this.aSr.aSf;
                            bVar2.setPriority(3);
                            bVar3 = this.aSr.aSf;
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
            aVar2 = this.aSr.aSg;
            if (aVar2 == null) {
                bVar4 = this.aSr.aSf;
                if (bVar4 == null) {
                    this.aSr.aSg = new ActivationActivity.a(this.aSr, null);
                    aVar3 = this.aSr.aSg;
                    aVar3.setPriority(3);
                    aVar4 = this.aSr.aSg;
                    aVar4.execute(new String[0]);
                    return;
                }
                return;
            }
            return;
        }
        this.aSr.setResult(0);
        this.aSr.finish();
    }
}
