package com.baidu.tieba.account;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
/* loaded from: classes.dex */
class ab implements View.OnClickListener {
    final /* synthetic */ Register2Activity awk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(Register2Activity register2Activity) {
        this.awk = register2Activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        TextView textView;
        TextView textView2;
        Button button;
        ImageView imageView;
        ImageView imageView2;
        RelativeLayout relativeLayout;
        ImageView imageView3;
        ag agVar;
        com.baidu.tbadk.core.data.n nVar;
        com.baidu.tbadk.core.data.n nVar2;
        ag agVar2;
        Button button2;
        ah ahVar;
        ag agVar3;
        ah ahVar2;
        ah ahVar3;
        ag agVar4;
        EditText editText;
        EditText editText2;
        view2 = this.awk.avD;
        if (view != view2) {
            textView2 = this.awk.avE;
            if (view != textView2) {
                button = this.awk.avF;
                if (view != button) {
                    imageView = this.awk.avG;
                    if (view != imageView) {
                        imageView2 = this.awk.avH;
                        if (view == imageView2) {
                            editText = this.awk.avR;
                            editText.setText((CharSequence) null);
                            return;
                        }
                        relativeLayout = this.awk.avT;
                        if (view != relativeLayout) {
                            imageView3 = this.awk.awa;
                            if (view != imageView3) {
                                button2 = this.awk.avI;
                                if (view != button2) {
                                    return;
                                }
                            }
                            agVar = this.awk.awf;
                            if (agVar == null) {
                                nVar = this.awk.awh;
                                if (nVar != null) {
                                    Register2Activity register2Activity = this.awk;
                                    Register2Activity register2Activity2 = this.awk;
                                    nVar2 = this.awk.awh;
                                    register2Activity.awf = new ag(register2Activity2, nVar2.qe().getVcode_pic_url());
                                    agVar2 = this.awk.awf;
                                    agVar2.execute(new String[0]);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        ahVar = this.awk.awg;
                        if (ahVar == null) {
                            agVar3 = this.awk.awf;
                            if (agVar3 != null) {
                                agVar4 = this.awk.awf;
                                agVar4.cancel();
                            }
                            this.awk.awg = new ah(this.awk, null);
                            ahVar2 = this.awk.awg;
                            ahVar2.setPriority(3);
                            ahVar3 = this.awk.awg;
                            ahVar3.execute(new String[0]);
                            return;
                        }
                        return;
                    }
                    editText2 = this.awk.avP;
                    editText2.setText((CharSequence) null);
                    return;
                }
                this.awk.Er();
                return;
            }
        }
        textView = this.awk.avE;
        if (view == textView) {
            this.awk.setResult(0);
        }
        this.awk.finish();
    }
}
