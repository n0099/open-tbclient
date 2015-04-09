package com.baidu.tieba.account;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
class w implements View.OnClickListener {
    final /* synthetic */ ActivationActivity avu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(ActivationActivity activationActivity) {
        this.avu = activationActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2;
        ImageView imageView;
        EditText editText;
        boolean z;
        aa aaVar;
        z zVar;
        aa aaVar2;
        aa aaVar3;
        z zVar2;
        aa aaVar4;
        z zVar3;
        z zVar4;
        view2 = this.avu.mBack;
        if (view != view2) {
            relativeLayout = this.avu.avg;
            if (view != relativeLayout) {
                relativeLayout2 = this.avu.avh;
                if (view != relativeLayout2) {
                    imageView = this.avu.avb;
                    if (view == imageView) {
                        editText = this.avu.avf;
                        editText.setText((CharSequence) null);
                        return;
                    }
                    return;
                }
                z = this.avu.avk;
                if (z) {
                    aaVar = this.avu.avi;
                    if (aaVar == null) {
                        zVar = this.avu.avj;
                        if (zVar == null) {
                            this.avu.avi = new aa(this.avu, null);
                            aaVar2 = this.avu.avi;
                            aaVar2.setPriority(3);
                            aaVar3 = this.avu.avi;
                            aaVar3.execute(new String[0]);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            zVar2 = this.avu.avj;
            if (zVar2 == null) {
                aaVar4 = this.avu.avi;
                if (aaVar4 == null) {
                    this.avu.avj = new z(this.avu, null);
                    zVar3 = this.avu.avj;
                    zVar3.setPriority(3);
                    zVar4 = this.avu.avj;
                    zVar4.execute(new String[0]);
                    return;
                }
                return;
            }
            return;
        }
        this.avu.setResult(0);
        this.avu.finish();
    }
}
