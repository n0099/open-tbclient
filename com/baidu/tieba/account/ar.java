package com.baidu.tieba.account;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
class ar implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Register2Activity f655a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(Register2Activity register2Activity) {
        this.f655a = register2Activity;
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
        com.baidu.tieba.model.al alVar;
        com.baidu.tieba.model.al alVar2;
        aw awVar2;
        Button button3;
        ax axVar;
        aw awVar3;
        ax axVar2;
        ax axVar3;
        aw awVar4;
        EditText editText;
        EditText editText2;
        imageView = this.f655a.l;
        if (view != imageView) {
            button = this.f655a.m;
            if (view != button) {
                button2 = this.f655a.n;
                if (view != button2) {
                    imageView2 = this.f655a.o;
                    if (view != imageView2) {
                        imageView3 = this.f655a.p;
                        if (view == imageView3) {
                            editText = this.f655a.z;
                            editText.setText((CharSequence) null);
                            return;
                        }
                        relativeLayout = this.f655a.B;
                        if (view != relativeLayout) {
                            imageView4 = this.f655a.J;
                            if (view != imageView4) {
                                button3 = this.f655a.q;
                                if (view != button3) {
                                    return;
                                }
                            }
                            awVar = this.f655a.Q;
                            if (awVar == null) {
                                alVar = this.f655a.S;
                                if (alVar != null) {
                                    Register2Activity register2Activity = this.f655a;
                                    Register2Activity register2Activity2 = this.f655a;
                                    alVar2 = this.f655a.S;
                                    register2Activity.Q = new aw(register2Activity2, alVar2.b().getVcode_pic_url());
                                    awVar2 = this.f655a.Q;
                                    awVar2.execute(new String[0]);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        axVar = this.f655a.R;
                        if (axVar == null) {
                            awVar3 = this.f655a.Q;
                            if (awVar3 != null) {
                                awVar4 = this.f655a.Q;
                                awVar4.cancel();
                            }
                            this.f655a.R = new ax(this.f655a, null);
                            axVar2 = this.f655a.R;
                            axVar2.setPriority(3);
                            axVar3 = this.f655a.R;
                            axVar3.execute(new String[0]);
                            return;
                        }
                        return;
                    }
                    editText2 = this.f655a.x;
                    editText2.setText((CharSequence) null);
                    return;
                }
                this.f655a.p();
                return;
            }
        }
        this.f655a.setResult(0);
        this.f655a.finish();
        com.baidu.tieba.util.z.a("Register2Activity", "mButtonBack", "onClick");
    }
}
