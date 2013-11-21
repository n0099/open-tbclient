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
class at implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Register2Activity f1057a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(Register2Activity register2Activity) {
        this.f1057a = register2Activity;
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
        ay ayVar;
        be beVar;
        be beVar2;
        ay ayVar2;
        Button button2;
        az azVar;
        ay ayVar3;
        az azVar2;
        az azVar3;
        ay ayVar4;
        EditText editText;
        EditText editText2;
        imageView = this.f1057a.h;
        if (view != imageView) {
            textView2 = this.f1057a.i;
            if (view != textView2) {
                button = this.f1057a.j;
                if (view == button) {
                    this.f1057a.g();
                    return;
                }
                imageView2 = this.f1057a.k;
                if (view == imageView2) {
                    editText2 = this.f1057a.t;
                    editText2.setText((CharSequence) null);
                    return;
                }
                imageView3 = this.f1057a.l;
                if (view == imageView3) {
                    editText = this.f1057a.v;
                    editText.setText((CharSequence) null);
                    return;
                }
                relativeLayout = this.f1057a.x;
                if (view == relativeLayout) {
                    azVar = this.f1057a.O;
                    if (azVar == null) {
                        ayVar3 = this.f1057a.N;
                        if (ayVar3 != null) {
                            ayVar4 = this.f1057a.N;
                            ayVar4.cancel();
                        }
                        this.f1057a.O = new az(this.f1057a, null);
                        azVar2 = this.f1057a.O;
                        azVar2.setPriority(3);
                        azVar3 = this.f1057a.O;
                        azVar3.execute(new String[0]);
                        return;
                    }
                    return;
                }
                imageView4 = this.f1057a.F;
                if (view != imageView4) {
                    button2 = this.f1057a.m;
                    if (view != button2) {
                        return;
                    }
                }
                ayVar = this.f1057a.N;
                if (ayVar == null) {
                    beVar = this.f1057a.P;
                    if (beVar != null) {
                        Register2Activity register2Activity = this.f1057a;
                        Register2Activity register2Activity2 = this.f1057a;
                        beVar2 = this.f1057a.P;
                        register2Activity.N = new ay(register2Activity2, beVar2.b().getVcode_pic_url());
                        ayVar2 = this.f1057a.N;
                        ayVar2.execute(new String[0]);
                        return;
                    }
                    return;
                }
                return;
            }
        }
        textView = this.f1057a.i;
        if (view == textView) {
            this.f1057a.setResult(0);
        }
        this.f1057a.finish();
        bg.a("Register2Activity", "mButtonBack", "onClick");
    }
}
