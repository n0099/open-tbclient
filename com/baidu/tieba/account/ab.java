package com.baidu.tieba.account;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
/* loaded from: classes.dex */
class ab implements View.OnClickListener {
    final /* synthetic */ Register2Activity awc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(Register2Activity register2Activity) {
        this.awc = register2Activity;
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
        view2 = this.awc.avv;
        if (view != view2) {
            textView2 = this.awc.avw;
            if (view != textView2) {
                button = this.awc.avx;
                if (view != button) {
                    imageView = this.awc.avy;
                    if (view != imageView) {
                        imageView2 = this.awc.avz;
                        if (view == imageView2) {
                            editText = this.awc.avJ;
                            editText.setText((CharSequence) null);
                            return;
                        }
                        relativeLayout = this.awc.avL;
                        if (view != relativeLayout) {
                            imageView3 = this.awc.avS;
                            if (view != imageView3) {
                                button2 = this.awc.avA;
                                if (view != button2) {
                                    return;
                                }
                            }
                            agVar = this.awc.avX;
                            if (agVar == null) {
                                nVar = this.awc.avZ;
                                if (nVar != null) {
                                    Register2Activity register2Activity = this.awc;
                                    Register2Activity register2Activity2 = this.awc;
                                    nVar2 = this.awc.avZ;
                                    register2Activity.avX = new ag(register2Activity2, nVar2.qe().getVcode_pic_url());
                                    agVar2 = this.awc.avX;
                                    agVar2.execute(new String[0]);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        ahVar = this.awc.avY;
                        if (ahVar == null) {
                            agVar3 = this.awc.avX;
                            if (agVar3 != null) {
                                agVar4 = this.awc.avX;
                                agVar4.cancel();
                            }
                            this.awc.avY = new ah(this.awc, null);
                            ahVar2 = this.awc.avY;
                            ahVar2.setPriority(3);
                            ahVar3 = this.awc.avY;
                            ahVar3.execute(new String[0]);
                            return;
                        }
                        return;
                    }
                    editText2 = this.awc.avH;
                    editText2.setText((CharSequence) null);
                    return;
                }
                this.awc.El();
                return;
            }
        }
        textView = this.awc.avw;
        if (view == textView) {
            this.awc.setResult(0);
        }
        this.awc.finish();
    }
}
