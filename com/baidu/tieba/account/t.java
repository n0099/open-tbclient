package com.baidu.tieba.account;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
/* loaded from: classes.dex */
class t implements View.OnClickListener {
    final /* synthetic */ Register2Activity afJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(Register2Activity register2Activity) {
        this.afJ = register2Activity;
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
        view2 = this.afJ.KB;
        if (view != view2) {
            textView2 = this.afJ.afg;
            if (view != textView2) {
                button = this.afJ.afh;
                if (view != button) {
                    imageView = this.afJ.afi;
                    if (view != imageView) {
                        imageView2 = this.afJ.afj;
                        if (view == imageView2) {
                            editText = this.afJ.afs;
                            editText.setText((CharSequence) null);
                            return;
                        }
                        relativeLayout = this.afJ.aft;
                        if (view != relativeLayout) {
                            imageView3 = this.afJ.Kw;
                            if (view != imageView3) {
                                button2 = this.afJ.afk;
                                if (view != button2) {
                                    return;
                                }
                            }
                            yVar = this.afJ.afE;
                            if (yVar == null) {
                                jVar = this.afJ.afG;
                                if (jVar != null) {
                                    Register2Activity register2Activity = this.afJ;
                                    Register2Activity register2Activity2 = this.afJ;
                                    jVar2 = this.afJ.afG;
                                    register2Activity.afE = new y(register2Activity2, jVar2.jZ().getVcode_pic_url());
                                    yVar2 = this.afJ.afE;
                                    yVar2.execute(new String[0]);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        zVar = this.afJ.afF;
                        if (zVar == null) {
                            yVar3 = this.afJ.afE;
                            if (yVar3 != null) {
                                yVar4 = this.afJ.afE;
                                yVar4.cancel();
                            }
                            this.afJ.afF = new z(this.afJ, null);
                            zVar2 = this.afJ.afF;
                            zVar2.setPriority(3);
                            zVar3 = this.afJ.afF;
                            zVar3.execute(new String[0]);
                            return;
                        }
                        return;
                    }
                    editText2 = this.afJ.afq;
                    editText2.setText((CharSequence) null);
                    return;
                }
                this.afJ.xg();
                return;
            }
        }
        textView = this.afJ.afg;
        if (view == textView) {
            this.afJ.setResult(0);
        }
        this.afJ.finish();
    }
}
