package com.baidu.tieba.account;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tieba.account.ActivationActivity;
/* loaded from: classes.dex */
class p implements View.OnClickListener {
    final /* synthetic */ ActivationActivity aIG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(ActivationActivity activationActivity) {
        this.aIG = activationActivity;
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
        view2 = this.aIG.afm;
        if (view != view2) {
            if (view != this.aIG.aIs) {
                if (view != this.aIG.aIt) {
                    imageView = this.aIG.aIn;
                    if (view == imageView) {
                        this.aIG.aIr.setText((CharSequence) null);
                        return;
                    }
                    return;
                } else if (this.aIG.aIw) {
                    bVar = this.aIG.aIu;
                    if (bVar == null) {
                        aVar = this.aIG.aIv;
                        if (aVar == null) {
                            this.aIG.aIu = new ActivationActivity.b(this.aIG, null);
                            bVar2 = this.aIG.aIu;
                            bVar2.setPriority(3);
                            bVar3 = this.aIG.aIu;
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
            aVar2 = this.aIG.aIv;
            if (aVar2 == null) {
                bVar4 = this.aIG.aIu;
                if (bVar4 == null) {
                    this.aIG.aIv = new ActivationActivity.a(this.aIG, null);
                    aVar3 = this.aIG.aIv;
                    aVar3.setPriority(3);
                    aVar4 = this.aIG.aIv;
                    aVar4.execute(new String[0]);
                    return;
                }
                return;
            }
            return;
        }
        this.aIG.setResult(0);
        this.aIG.finish();
    }
}
