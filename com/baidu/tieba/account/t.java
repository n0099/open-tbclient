package com.baidu.tieba.account;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class t implements View.OnClickListener {
    final /* synthetic */ Register2Activity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(Register2Activity register2Activity) {
        this.a = register2Activity;
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
        com.baidu.tbadk.core.data.i iVar;
        com.baidu.tbadk.core.data.i iVar2;
        y yVar2;
        Button button2;
        z zVar;
        y yVar3;
        z zVar2;
        z zVar3;
        y yVar4;
        EditText editText;
        EditText editText2;
        view2 = this.a.h;
        if (view != view2) {
            textView2 = this.a.i;
            if (view != textView2) {
                button = this.a.j;
                if (view != button) {
                    imageView = this.a.k;
                    if (view != imageView) {
                        imageView2 = this.a.l;
                        if (view == imageView2) {
                            editText = this.a.v;
                            editText.setText((CharSequence) null);
                            return;
                        }
                        relativeLayout = this.a.x;
                        if (view != relativeLayout) {
                            imageView3 = this.a.F;
                            if (view != imageView3) {
                                button2 = this.a.m;
                                if (view != button2) {
                                    return;
                                }
                            }
                            yVar = this.a.N;
                            if (yVar == null) {
                                iVar = this.a.P;
                                if (iVar != null) {
                                    Register2Activity register2Activity = this.a;
                                    Register2Activity register2Activity2 = this.a;
                                    iVar2 = this.a.P;
                                    register2Activity.N = new y(register2Activity2, iVar2.b().getVcode_pic_url());
                                    yVar2 = this.a.N;
                                    yVar2.execute(new String[0]);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        zVar = this.a.O;
                        if (zVar == null) {
                            yVar3 = this.a.N;
                            if (yVar3 != null) {
                                yVar4 = this.a.N;
                                yVar4.cancel();
                            }
                            this.a.O = new z(this.a, null);
                            zVar2 = this.a.O;
                            zVar2.setPriority(3);
                            zVar3 = this.a.O;
                            zVar3.execute(new String[0]);
                            return;
                        }
                        return;
                    }
                    editText2 = this.a.t;
                    editText2.setText((CharSequence) null);
                    return;
                }
                this.a.g();
                return;
            }
        }
        textView = this.a.i;
        if (view == textView) {
            this.a.setResult(0);
        }
        this.a.finish();
        BdLog.i("Register2Activity", "mButtonBack", "onClick");
    }
}
