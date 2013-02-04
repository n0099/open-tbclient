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
        button = this.a.g;
        if (view != button) {
            button2 = this.a.h;
            if (view != button2) {
                button3 = this.a.i;
                if (view == button3) {
                    this.a.m();
                    return;
                }
                imageView = this.a.j;
                if (view == imageView) {
                    editText2 = this.a.s;
                    editText2.setText((CharSequence) null);
                    return;
                }
                imageView2 = this.a.k;
                if (view == imageView2) {
                    editText = this.a.u;
                    editText.setText((CharSequence) null);
                    return;
                }
                relativeLayout = this.a.w;
                if (view == relativeLayout) {
                    bcVar = this.a.M;
                    if (bcVar == null) {
                        bbVar3 = this.a.L;
                        if (bbVar3 != null) {
                            bbVar4 = this.a.L;
                            bbVar4.a();
                        }
                        this.a.M = new bc(this.a, null);
                        bcVar2 = this.a.M;
                        bcVar2.execute(new String[0]);
                        return;
                    }
                    return;
                }
                imageView3 = this.a.E;
                if (view != imageView3) {
                    button4 = this.a.l;
                    if (view != button4) {
                        return;
                    }
                }
                bbVar = this.a.L;
                if (bbVar == null) {
                    gVar = this.a.N;
                    if (gVar != null) {
                        Register2Activity register2Activity = this.a;
                        Register2Activity register2Activity2 = this.a;
                        gVar2 = this.a.N;
                        register2Activity.L = new bb(register2Activity2, gVar2.b().d());
                        bbVar2 = this.a.L;
                        bbVar2.execute(new String[0]);
                        return;
                    }
                    return;
                }
                return;
            }
        }
        this.a.setResult(0);
        this.a.finish();
        com.baidu.tieba.c.ae.a("Register2Activity", "mButtonBack", "onClick");
    }
}
