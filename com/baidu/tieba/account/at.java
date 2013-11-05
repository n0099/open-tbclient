package com.baidu.tieba.account;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.tieba.model.bd;
import com.baidu.tieba.util.be;
/* loaded from: classes.dex */
class at implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Register2Activity f1032a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(Register2Activity register2Activity) {
        this.f1032a = register2Activity;
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
        ay ayVar;
        bd bdVar;
        bd bdVar2;
        ay ayVar2;
        Button button3;
        az azVar;
        ay ayVar3;
        az azVar2;
        az azVar3;
        ay ayVar4;
        EditText editText;
        EditText editText2;
        imageView = this.f1032a.l;
        if (view != imageView) {
            button = this.f1032a.m;
            if (view != button) {
                button2 = this.f1032a.n;
                if (view == button2) {
                    this.f1032a.o();
                    return;
                }
                imageView2 = this.f1032a.o;
                if (view == imageView2) {
                    editText2 = this.f1032a.x;
                    editText2.setText((CharSequence) null);
                    return;
                }
                imageView3 = this.f1032a.p;
                if (view == imageView3) {
                    editText = this.f1032a.z;
                    editText.setText((CharSequence) null);
                    return;
                }
                relativeLayout = this.f1032a.B;
                if (view == relativeLayout) {
                    azVar = this.f1032a.R;
                    if (azVar == null) {
                        ayVar3 = this.f1032a.Q;
                        if (ayVar3 != null) {
                            ayVar4 = this.f1032a.Q;
                            ayVar4.cancel();
                        }
                        this.f1032a.R = new az(this.f1032a, null);
                        azVar2 = this.f1032a.R;
                        azVar2.setPriority(3);
                        azVar3 = this.f1032a.R;
                        azVar3.execute(new String[0]);
                        return;
                    }
                    return;
                }
                imageView4 = this.f1032a.J;
                if (view != imageView4) {
                    button3 = this.f1032a.q;
                    if (view != button3) {
                        return;
                    }
                }
                ayVar = this.f1032a.Q;
                if (ayVar == null) {
                    bdVar = this.f1032a.S;
                    if (bdVar != null) {
                        Register2Activity register2Activity = this.f1032a;
                        Register2Activity register2Activity2 = this.f1032a;
                        bdVar2 = this.f1032a.S;
                        register2Activity.Q = new ay(register2Activity2, bdVar2.b().getVcode_pic_url());
                        ayVar2 = this.f1032a.Q;
                        ayVar2.execute(new String[0]);
                        return;
                    }
                    return;
                }
                return;
            }
        }
        this.f1032a.setResult(0);
        this.f1032a.finish();
        be.a("Register2Activity", "mButtonBack", "onClick");
    }
}
