package com.baidu.tieba.account;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
/* loaded from: classes.dex */
final class bg implements View.OnClickListener {
    final /* synthetic */ Register2Activity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(Register2Activity register2Activity) {
        this.a = register2Activity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ImageView imageView;
        TextView textView;
        TextView textView2;
        Button button;
        ImageView imageView2;
        ImageView imageView3;
        RelativeLayout relativeLayout;
        ImageView imageView4;
        bl blVar;
        com.baidu.tieba.model.at atVar;
        com.baidu.tieba.model.at atVar2;
        bl blVar2;
        Button button2;
        bm bmVar;
        bl blVar3;
        bm bmVar2;
        bm bmVar3;
        bl blVar4;
        EditText editText;
        EditText editText2;
        imageView = this.a.h;
        if (view != imageView) {
            textView2 = this.a.i;
            if (view != textView2) {
                button = this.a.j;
                if (view != button) {
                    imageView2 = this.a.k;
                    if (view != imageView2) {
                        imageView3 = this.a.l;
                        if (view == imageView3) {
                            editText = this.a.v;
                            editText.setText((CharSequence) null);
                            return;
                        }
                        relativeLayout = this.a.x;
                        if (view != relativeLayout) {
                            imageView4 = this.a.F;
                            if (view != imageView4) {
                                button2 = this.a.m;
                                if (view != button2) {
                                    return;
                                }
                            }
                            blVar = this.a.N;
                            if (blVar == null) {
                                atVar = this.a.P;
                                if (atVar != null) {
                                    Register2Activity register2Activity = this.a;
                                    Register2Activity register2Activity2 = this.a;
                                    atVar2 = this.a.P;
                                    register2Activity.N = new bl(register2Activity2, atVar2.b().getVcode_pic_url());
                                    blVar2 = this.a.N;
                                    blVar2.execute(new String[0]);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        bmVar = this.a.O;
                        if (bmVar == null) {
                            blVar3 = this.a.N;
                            if (blVar3 != null) {
                                blVar4 = this.a.N;
                                blVar4.cancel();
                            }
                            this.a.O = new bm(this.a, (byte) 0);
                            bmVar2 = this.a.O;
                            bmVar2.setPriority(3);
                            bmVar3 = this.a.O;
                            bmVar3.execute(new String[0]);
                            return;
                        }
                        return;
                    }
                    editText2 = this.a.t;
                    editText2.setText((CharSequence) null);
                    return;
                }
                this.a.f();
                return;
            }
        }
        textView = this.a.i;
        if (view == textView) {
            this.a.setResult(0);
        }
        this.a.finish();
        com.baidu.adp.lib.util.e.a("Register2Activity", "mButtonBack", "onClick");
    }
}
