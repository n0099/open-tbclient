package com.baidu.tieba.account;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
class aw implements View.OnClickListener {
    final /* synthetic */ Register2Activity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(Register2Activity register2Activity) {
        this.a = register2Activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Button button;
        Button button2;
        Button button3;
        ImageView imageView;
        ImageView imageView2;
        RelativeLayout relativeLayout;
        ImageView imageView3;
        bb bbVar;
        com.baidu.tieba.b.g gVar;
        com.baidu.tieba.b.g gVar2;
        bb bbVar2;
        Button button4;
        bc bcVar;
        bb bbVar3;
        bc bcVar2;
        bb bbVar4;
        EditText editText;
        EditText editText2;
        button = this.a.l;
        if (view != button) {
            button2 = this.a.m;
            if (view != button2) {
                button3 = this.a.n;
                if (view != button3) {
                    imageView = this.a.o;
                    if (view != imageView) {
                        imageView2 = this.a.p;
                        if (view == imageView2) {
                            editText = this.a.z;
                            editText.setText((CharSequence) null);
                            return;
                        }
                        relativeLayout = this.a.B;
                        if (view != relativeLayout) {
                            imageView3 = this.a.J;
                            if (view != imageView3) {
                                button4 = this.a.q;
                                if (view != button4) {
                                    return;
                                }
                            }
                            bbVar = this.a.Q;
                            if (bbVar == null) {
                                gVar = this.a.S;
                                if (gVar != null) {
                                    Register2Activity register2Activity = this.a;
                                    Register2Activity register2Activity2 = this.a;
                                    gVar2 = this.a.S;
                                    register2Activity.Q = new bb(register2Activity2, gVar2.b().d());
                                    bbVar2 = this.a.Q;
                                    bbVar2.execute(new String[0]);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        bcVar = this.a.R;
                        if (bcVar == null) {
                            bbVar3 = this.a.Q;
                            if (bbVar3 != null) {
                                bbVar4 = this.a.Q;
                                bbVar4.a();
                            }
                            this.a.R = new bc(this.a, null);
                            bcVar2 = this.a.R;
                            bcVar2.execute(new String[0]);
                            return;
                        }
                        return;
                    }
                    editText2 = this.a.x;
                    editText2.setText((CharSequence) null);
                    return;
                }
                this.a.o();
                return;
            }
        }
        this.a.setResult(0);
        this.a.finish();
        com.baidu.tieba.c.ag.a("Register2Activity", "mButtonBack", "onClick");
    }
}
