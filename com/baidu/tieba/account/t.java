package com.baidu.tieba.account;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
/* loaded from: classes.dex */
class t implements View.OnClickListener {
    final /* synthetic */ Register2Activity afR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(Register2Activity register2Activity) {
        this.afR = register2Activity;
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
        y yVar;
        com.baidu.tbadk.core.data.j jVar;
        com.baidu.tbadk.core.data.j jVar2;
        y yVar2;
        Button button2;
        z zVar;
        y yVar3;
        z zVar2;
        z zVar3;
        y yVar4;
        EditText editText;
        EditText editText2;
        view2 = this.afR.KC;
        if (view != view2) {
            textView2 = this.afR.afo;
            if (view != textView2) {
                button = this.afR.afp;
                if (view != button) {
                    imageView = this.afR.afq;
                    if (view != imageView) {
                        imageView2 = this.afR.afr;
                        if (view == imageView2) {
                            editText = this.afR.afA;
                            editText.setText((CharSequence) null);
                            return;
                        }
                        relativeLayout = this.afR.afB;
                        if (view != relativeLayout) {
                            imageView3 = this.afR.Kx;
                            if (view != imageView3) {
                                button2 = this.afR.afs;
                                if (view != button2) {
                                    return;
                                }
                            }
                            yVar = this.afR.afM;
                            if (yVar == null) {
                                jVar = this.afR.afO;
                                if (jVar != null) {
                                    Register2Activity register2Activity = this.afR;
                                    Register2Activity register2Activity2 = this.afR;
                                    jVar2 = this.afR.afO;
                                    register2Activity.afM = new y(register2Activity2, jVar2.jZ().getVcode_pic_url());
                                    yVar2 = this.afR.afM;
                                    yVar2.execute(new String[0]);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        zVar = this.afR.afN;
                        if (zVar == null) {
                            yVar3 = this.afR.afM;
                            if (yVar3 != null) {
                                yVar4 = this.afR.afM;
                                yVar4.cancel();
                            }
                            this.afR.afN = new z(this.afR, null);
                            zVar2 = this.afR.afN;
                            zVar2.setPriority(3);
                            zVar3 = this.afR.afN;
                            zVar3.execute(new String[0]);
                            return;
                        }
                        return;
                    }
                    editText2 = this.afR.afy;
                    editText2.setText((CharSequence) null);
                    return;
                }
                this.afR.xi();
                return;
            }
        }
        textView = this.afR.afo;
        if (view == textView) {
            this.afR.setResult(0);
        }
        this.afR.finish();
    }
}
