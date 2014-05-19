package com.baidu.tieba.account;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class o implements View.OnClickListener {
    final /* synthetic */ ActivationActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(ActivationActivity activationActivity) {
        this.a = activationActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2;
        ImageView imageView;
        EditText editText;
        boolean z;
        s sVar;
        r rVar;
        s sVar2;
        s sVar3;
        r rVar2;
        s sVar4;
        r rVar3;
        r rVar4;
        view2 = this.a.c;
        if (view != view2) {
            relativeLayout = this.a.k;
            if (view != relativeLayout) {
                relativeLayout2 = this.a.l;
                if (view != relativeLayout2) {
                    imageView = this.a.e;
                    if (view == imageView) {
                        editText = this.a.j;
                        editText.setText((CharSequence) null);
                        return;
                    }
                    return;
                }
                z = this.a.o;
                if (z) {
                    sVar = this.a.m;
                    if (sVar == null) {
                        rVar = this.a.n;
                        if (rVar == null) {
                            this.a.m = new s(this.a, null);
                            sVar2 = this.a.m;
                            sVar2.setPriority(3);
                            sVar3 = this.a.m;
                            sVar3.execute(new String[0]);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            rVar2 = this.a.n;
            if (rVar2 == null) {
                sVar4 = this.a.m;
                if (sVar4 == null) {
                    this.a.n = new r(this.a, null);
                    rVar3 = this.a.n;
                    rVar3.setPriority(3);
                    rVar4 = this.a.n;
                    rVar4.execute(new String[0]);
                    return;
                }
                return;
            }
            return;
        }
        this.a.setResult(0);
        this.a.finish();
        BdLog.i("ActivationActivity", "mBack", "onClick");
    }
}
