package com.baidu.tieba.account;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.model.be;
import com.baidu.tieba.util.bg;
/* loaded from: classes.dex */
class as implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Register2Activity f1054a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(Register2Activity register2Activity) {
        this.f1054a = register2Activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ImageView imageView;
        TextView textView;
        TextView textView2;
        Button button;
        ImageView imageView2;
        ImageView imageView3;
        RelativeLayout relativeLayout;
        ImageView imageView4;
        ax axVar;
        be beVar;
        be beVar2;
        ax axVar2;
        Button button2;
        ay ayVar;
        ax axVar3;
        ay ayVar2;
        ay ayVar3;
        ax axVar4;
        EditText editText;
        EditText editText2;
        imageView = this.f1054a.h;
        if (view != imageView) {
            textView2 = this.f1054a.i;
            if (view != textView2) {
                button = this.f1054a.j;
                if (view == button) {
                    this.f1054a.g();
                    return;
                }
                imageView2 = this.f1054a.k;
                if (view == imageView2) {
                    editText2 = this.f1054a.t;
                    editText2.setText((CharSequence) null);
                    return;
                }
                imageView3 = this.f1054a.l;
                if (view == imageView3) {
                    editText = this.f1054a.v;
                    editText.setText((CharSequence) null);
                    return;
                }
                relativeLayout = this.f1054a.x;
                if (view == relativeLayout) {
                    ayVar = this.f1054a.O;
                    if (ayVar == null) {
                        axVar3 = this.f1054a.N;
                        if (axVar3 != null) {
                            axVar4 = this.f1054a.N;
                            axVar4.cancel();
                        }
                        this.f1054a.O = new ay(this.f1054a, null);
                        ayVar2 = this.f1054a.O;
                        ayVar2.setPriority(3);
                        ayVar3 = this.f1054a.O;
                        ayVar3.execute(new String[0]);
                        return;
                    }
                    return;
                }
                imageView4 = this.f1054a.F;
                if (view != imageView4) {
                    button2 = this.f1054a.m;
                    if (view != button2) {
                        return;
                    }
                }
                axVar = this.f1054a.N;
                if (axVar == null) {
                    beVar = this.f1054a.P;
                    if (beVar != null) {
                        Register2Activity register2Activity = this.f1054a;
                        Register2Activity register2Activity2 = this.f1054a;
                        beVar2 = this.f1054a.P;
                        register2Activity.N = new ax(register2Activity2, beVar2.b().getVcode_pic_url());
                        axVar2 = this.f1054a.N;
                        axVar2.execute(new String[0]);
                        return;
                    }
                    return;
                }
                return;
            }
        }
        textView = this.f1054a.i;
        if (view == textView) {
            this.f1054a.setResult(0);
        }
        this.f1054a.finish();
        bg.a("Register2Activity", "mButtonBack", "onClick");
    }
}
