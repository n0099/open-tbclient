package com.baidu.tieba.account;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
class as implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Register2Activity f865a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(Register2Activity register2Activity) {
        this.f865a = register2Activity;
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
        com.baidu.tieba.model.at atVar;
        com.baidu.tieba.model.at atVar2;
        ax axVar2;
        Button button3;
        ay ayVar;
        ax axVar3;
        ay ayVar2;
        ay ayVar3;
        ax axVar4;
        EditText editText;
        EditText editText2;
        imageView = this.f865a.l;
        if (view != imageView) {
            button = this.f865a.m;
            if (view != button) {
                button2 = this.f865a.n;
                if (view != button2) {
                    imageView2 = this.f865a.o;
                    if (view != imageView2) {
                        imageView3 = this.f865a.p;
                        if (view == imageView3) {
                            editText = this.f865a.z;
                            editText.setText((CharSequence) null);
                            return;
                        }
                        relativeLayout = this.f865a.B;
                        if (view != relativeLayout) {
                            imageView4 = this.f865a.J;
                            if (view != imageView4) {
                                button3 = this.f865a.q;
                                if (view != button3) {
                                    return;
                                }
                            }
                            axVar = this.f865a.Q;
                            if (axVar == null) {
                                atVar = this.f865a.S;
                                if (atVar != null) {
                                    Register2Activity register2Activity = this.f865a;
                                    Register2Activity register2Activity2 = this.f865a;
                                    atVar2 = this.f865a.S;
                                    register2Activity.Q = new ax(register2Activity2, atVar2.b().getVcode_pic_url());
                                    axVar2 = this.f865a.Q;
                                    axVar2.execute(new String[0]);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        ayVar = this.f865a.R;
                        if (ayVar == null) {
                            axVar3 = this.f865a.Q;
                            if (axVar3 != null) {
                                axVar4 = this.f865a.Q;
                                axVar4.cancel();
                            }
                            this.f865a.R = new ay(this.f865a, null);
                            ayVar2 = this.f865a.R;
                            ayVar2.setPriority(3);
                            ayVar3 = this.f865a.R;
                            ayVar3.execute(new String[0]);
                            return;
                        }
                        return;
                    }
                    editText2 = this.f865a.x;
                    editText2.setText((CharSequence) null);
                    return;
                }
                this.f865a.n();
                return;
            }
        }
        this.f865a.setResult(0);
        this.f865a.finish();
        com.baidu.tieba.util.aj.a("Register2Activity", "mButtonBack", "onClick");
    }
}
