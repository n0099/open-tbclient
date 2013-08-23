package com.baidu.tieba.account;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
class as implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Register2Activity f886a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(Register2Activity register2Activity) {
        this.f886a = register2Activity;
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
        com.baidu.tieba.model.as asVar;
        com.baidu.tieba.model.as asVar2;
        ax axVar2;
        Button button3;
        ay ayVar;
        ax axVar3;
        ay ayVar2;
        ay ayVar3;
        ax axVar4;
        EditText editText;
        EditText editText2;
        imageView = this.f886a.l;
        if (view != imageView) {
            button = this.f886a.m;
            if (view != button) {
                button2 = this.f886a.n;
                if (view != button2) {
                    imageView2 = this.f886a.o;
                    if (view != imageView2) {
                        imageView3 = this.f886a.p;
                        if (view == imageView3) {
                            editText = this.f886a.z;
                            editText.setText((CharSequence) null);
                            return;
                        }
                        relativeLayout = this.f886a.B;
                        if (view != relativeLayout) {
                            imageView4 = this.f886a.J;
                            if (view != imageView4) {
                                button3 = this.f886a.q;
                                if (view != button3) {
                                    return;
                                }
                            }
                            axVar = this.f886a.Q;
                            if (axVar == null) {
                                asVar = this.f886a.S;
                                if (asVar != null) {
                                    Register2Activity register2Activity = this.f886a;
                                    Register2Activity register2Activity2 = this.f886a;
                                    asVar2 = this.f886a.S;
                                    register2Activity.Q = new ax(register2Activity2, asVar2.b().getVcode_pic_url());
                                    axVar2 = this.f886a.Q;
                                    axVar2.execute(new String[0]);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        ayVar = this.f886a.R;
                        if (ayVar == null) {
                            axVar3 = this.f886a.Q;
                            if (axVar3 != null) {
                                axVar4 = this.f886a.Q;
                                axVar4.cancel();
                            }
                            this.f886a.R = new ay(this.f886a, null);
                            ayVar2 = this.f886a.R;
                            ayVar2.setPriority(3);
                            ayVar3 = this.f886a.R;
                            ayVar3.execute(new String[0]);
                            return;
                        }
                        return;
                    }
                    editText2 = this.f886a.x;
                    editText2.setText((CharSequence) null);
                    return;
                }
                this.f886a.n();
                return;
            }
        }
        this.f886a.setResult(0);
        this.f886a.finish();
        com.baidu.tieba.util.aq.a("Register2Activity", "mButtonBack", "onClick");
    }
}
