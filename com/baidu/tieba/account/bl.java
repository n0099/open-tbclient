package com.baidu.tieba.account;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
/* loaded from: classes.dex */
class bl implements View.OnClickListener {
    final /* synthetic */ Register2Activity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(Register2Activity register2Activity) {
        this.a = register2Activity;
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
        bq bqVar;
        com.baidu.tieba.model.be beVar;
        com.baidu.tieba.model.be beVar2;
        bq bqVar2;
        Button button2;
        br brVar;
        bq bqVar3;
        br brVar2;
        br brVar3;
        bq bqVar4;
        EditText editText;
        EditText editText2;
        imageView = this.a.h;
        if (view != imageView) {
            textView2 = this.a.i;
            if (view != textView2) {
                button = this.a.j;
                if (view == button) {
                    this.a.g();
                    return;
                }
                imageView2 = this.a.k;
                if (view == imageView2) {
                    editText2 = this.a.t;
                    editText2.setText((CharSequence) null);
                    return;
                }
                imageView3 = this.a.l;
                if (view == imageView3) {
                    editText = this.a.v;
                    editText.setText((CharSequence) null);
                    return;
                }
                relativeLayout = this.a.x;
                if (view == relativeLayout) {
                    brVar = this.a.O;
                    if (brVar == null) {
                        bqVar3 = this.a.N;
                        if (bqVar3 != null) {
                            bqVar4 = this.a.N;
                            bqVar4.cancel();
                        }
                        this.a.O = new br(this.a, null);
                        brVar2 = this.a.O;
                        brVar2.setPriority(3);
                        brVar3 = this.a.O;
                        brVar3.execute(new String[0]);
                        return;
                    }
                    return;
                }
                imageView4 = this.a.F;
                if (view != imageView4) {
                    button2 = this.a.m;
                    if (view != button2) {
                        return;
                    }
                }
                bqVar = this.a.N;
                if (bqVar == null) {
                    beVar = this.a.P;
                    if (beVar != null) {
                        Register2Activity register2Activity = this.a;
                        Register2Activity register2Activity2 = this.a;
                        beVar2 = this.a.P;
                        register2Activity.N = new bq(register2Activity2, beVar2.b().getVcode_pic_url());
                        bqVar2 = this.a.N;
                        bqVar2.execute(new String[0]);
                        return;
                    }
                    return;
                }
                return;
            }
        }
        textView = this.a.i;
        if (view == textView) {
            this.a.setResult(0);
        }
        this.a.finish();
        com.baidu.tieba.util.bo.a("Register2Activity", "mButtonBack", "onClick");
    }
}
