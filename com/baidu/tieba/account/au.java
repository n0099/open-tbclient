package com.baidu.tieba.account;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.model.be;
import com.baidu.tieba.util.bd;
/* loaded from: classes.dex */
class au implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Register2Activity f1068a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(Register2Activity register2Activity) {
        this.f1068a = register2Activity;
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
        az azVar;
        be beVar;
        be beVar2;
        az azVar2;
        Button button2;
        ba baVar;
        az azVar3;
        ba baVar2;
        ba baVar3;
        az azVar4;
        EditText editText;
        EditText editText2;
        imageView = this.f1068a.h;
        if (view != imageView) {
            textView2 = this.f1068a.i;
            if (view != textView2) {
                button = this.f1068a.j;
                if (view == button) {
                    this.f1068a.g();
                    return;
                }
                imageView2 = this.f1068a.k;
                if (view == imageView2) {
                    editText2 = this.f1068a.t;
                    editText2.setText((CharSequence) null);
                    return;
                }
                imageView3 = this.f1068a.l;
                if (view == imageView3) {
                    editText = this.f1068a.v;
                    editText.setText((CharSequence) null);
                    return;
                }
                relativeLayout = this.f1068a.x;
                if (view == relativeLayout) {
                    baVar = this.f1068a.O;
                    if (baVar == null) {
                        azVar3 = this.f1068a.N;
                        if (azVar3 != null) {
                            azVar4 = this.f1068a.N;
                            azVar4.cancel();
                        }
                        this.f1068a.O = new ba(this.f1068a, null);
                        baVar2 = this.f1068a.O;
                        baVar2.setPriority(3);
                        baVar3 = this.f1068a.O;
                        baVar3.execute(new String[0]);
                        return;
                    }
                    return;
                }
                imageView4 = this.f1068a.F;
                if (view != imageView4) {
                    button2 = this.f1068a.m;
                    if (view != button2) {
                        return;
                    }
                }
                azVar = this.f1068a.N;
                if (azVar == null) {
                    beVar = this.f1068a.P;
                    if (beVar != null) {
                        Register2Activity register2Activity = this.f1068a;
                        Register2Activity register2Activity2 = this.f1068a;
                        beVar2 = this.f1068a.P;
                        register2Activity.N = new az(register2Activity2, beVar2.b().getVcode_pic_url());
                        azVar2 = this.f1068a.N;
                        azVar2.execute(new String[0]);
                        return;
                    }
                    return;
                }
                return;
            }
        }
        textView = this.f1068a.i;
        if (view == textView) {
            this.f1068a.setResult(0);
        }
        this.f1068a.finish();
        bd.a("Register2Activity", "mButtonBack", "onClick");
    }
}
