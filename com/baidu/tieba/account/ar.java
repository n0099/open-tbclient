package com.baidu.tieba.account;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
class ar implements View.OnClickListener {
    final /* synthetic */ Register2Activity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(Register2Activity register2Activity) {
        this.a = register2Activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ImageView imageView;
        Button button;
        Button button2;
        ImageView imageView2;
        ImageView imageView3;
        RelativeLayout relativeLayout;
        ImageView imageView4;
        aw awVar;
        com.baidu.tieba.c.ai aiVar;
        com.baidu.tieba.c.ai aiVar2;
        aw awVar2;
        Button button3;
        ax axVar;
        aw awVar3;
        ax axVar2;
        ax axVar3;
        aw awVar4;
        EditText editText;
        EditText editText2;
        imageView = this.a.l;
        if (view != imageView) {
            button = this.a.m;
            if (view != button) {
                button2 = this.a.n;
                if (view != button2) {
                    imageView2 = this.a.o;
                    if (view != imageView2) {
                        imageView3 = this.a.p;
                        if (view == imageView3) {
                            editText = this.a.z;
                            editText.setText((CharSequence) null);
                            return;
                        }
                        relativeLayout = this.a.B;
                        if (view != relativeLayout) {
                            imageView4 = this.a.J;
                            if (view != imageView4) {
                                button3 = this.a.q;
                                if (view != button3) {
                                    return;
                                }
                            }
                            awVar = this.a.Q;
                            if (awVar == null) {
                                aiVar = this.a.S;
                                if (aiVar != null) {
                                    Register2Activity register2Activity = this.a;
                                    Register2Activity register2Activity2 = this.a;
                                    aiVar2 = this.a.S;
                                    register2Activity.Q = new aw(register2Activity2, aiVar2.b().d());
                                    awVar2 = this.a.Q;
                                    awVar2.execute(new String[0]);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        axVar = this.a.R;
                        if (axVar == null) {
                            awVar3 = this.a.Q;
                            if (awVar3 != null) {
                                awVar4 = this.a.Q;
                                awVar4.cancel();
                            }
                            this.a.R = new ax(this.a, null);
                            axVar2 = this.a.R;
                            axVar2.setPriority(3);
                            axVar3 = this.a.R;
                            axVar3.execute(new String[0]);
                            return;
                        }
                        return;
                    }
                    editText2 = this.a.x;
                    editText2.setText((CharSequence) null);
                    return;
                }
                this.a.p();
                return;
            }
        }
        this.a.setResult(0);
        this.a.finish();
        com.baidu.tieba.d.ae.a("Register2Activity", "mButtonBack", "onClick");
    }
}
