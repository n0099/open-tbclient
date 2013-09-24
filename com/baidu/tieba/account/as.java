package com.baidu.tieba.account;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
class as implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Register2Activity f902a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(Register2Activity register2Activity) {
        this.f902a = register2Activity;
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
        ax axVar;
        com.baidu.tieba.model.au auVar;
        com.baidu.tieba.model.au auVar2;
        ax axVar2;
        Button button3;
        ay ayVar;
        ax axVar3;
        ay ayVar2;
        ay ayVar3;
        ax axVar4;
        EditText editText;
        EditText editText2;
        imageView = this.f902a.l;
        if (view != imageView) {
            button = this.f902a.m;
            if (view != button) {
                button2 = this.f902a.n;
                if (view != button2) {
                    imageView2 = this.f902a.o;
                    if (view != imageView2) {
                        imageView3 = this.f902a.p;
                        if (view == imageView3) {
                            editText = this.f902a.z;
                            editText.setText((CharSequence) null);
                            return;
                        }
                        relativeLayout = this.f902a.B;
                        if (view != relativeLayout) {
                            imageView4 = this.f902a.J;
                            if (view != imageView4) {
                                button3 = this.f902a.q;
                                if (view != button3) {
                                    return;
                                }
                            }
                            axVar = this.f902a.Q;
                            if (axVar == null) {
                                auVar = this.f902a.S;
                                if (auVar != null) {
                                    Register2Activity register2Activity = this.f902a;
                                    Register2Activity register2Activity2 = this.f902a;
                                    auVar2 = this.f902a.S;
                                    register2Activity.Q = new ax(register2Activity2, auVar2.b().getVcode_pic_url());
                                    axVar2 = this.f902a.Q;
                                    axVar2.execute(new String[0]);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        ayVar = this.f902a.R;
                        if (ayVar == null) {
                            axVar3 = this.f902a.Q;
                            if (axVar3 != null) {
                                axVar4 = this.f902a.Q;
                                axVar4.cancel();
                            }
                            this.f902a.R = new ay(this.f902a, null);
                            ayVar2 = this.f902a.R;
                            ayVar2.setPriority(3);
                            ayVar3 = this.f902a.R;
                            ayVar3.execute(new String[0]);
                            return;
                        }
                        return;
                    }
                    editText2 = this.f902a.x;
                    editText2.setText((CharSequence) null);
                    return;
                }
                this.f902a.o();
                return;
            }
        }
        this.f902a.setResult(0);
        this.f902a.finish();
        com.baidu.tieba.util.av.a("Register2Activity", "mButtonBack", "onClick");
    }
}
