package com.baidu.tieba.account;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
/* loaded from: classes.dex */
final class z implements View.OnClickListener {
    final /* synthetic */ Register2Activity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(Register2Activity register2Activity) {
        this.a = register2Activity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        View view2;
        TextView textView;
        TextView textView2;
        Button button;
        ImageView imageView;
        ImageView imageView2;
        RelativeLayout relativeLayout;
        ImageView imageView3;
        ae aeVar;
        com.baidu.tbadk.core.data.h hVar;
        com.baidu.tbadk.core.data.h hVar2;
        ae aeVar2;
        Button button2;
        af afVar;
        ae aeVar3;
        af afVar2;
        af afVar3;
        ae aeVar4;
        EditText editText;
        EditText editText2;
        view2 = this.a.h;
        if (view != view2) {
            textView2 = this.a.i;
            if (view != textView2) {
                button = this.a.j;
                if (view != button) {
                    imageView = this.a.k;
                    if (view != imageView) {
                        imageView2 = this.a.l;
                        if (view == imageView2) {
                            editText = this.a.v;
                            editText.setText((CharSequence) null);
                            return;
                        }
                        relativeLayout = this.a.x;
                        if (view != relativeLayout) {
                            imageView3 = this.a.F;
                            if (view != imageView3) {
                                button2 = this.a.m;
                                if (view != button2) {
                                    return;
                                }
                            }
                            aeVar = this.a.N;
                            if (aeVar == null) {
                                hVar = this.a.P;
                                if (hVar != null) {
                                    Register2Activity register2Activity = this.a;
                                    Register2Activity register2Activity2 = this.a;
                                    hVar2 = this.a.P;
                                    register2Activity.N = new ae(register2Activity2, hVar2.b().getVcode_pic_url());
                                    aeVar2 = this.a.N;
                                    aeVar2.execute(new String[0]);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        afVar = this.a.O;
                        if (afVar == null) {
                            aeVar3 = this.a.N;
                            if (aeVar3 != null) {
                                aeVar4 = this.a.N;
                                aeVar4.cancel();
                            }
                            this.a.O = new af(this.a, (byte) 0);
                            afVar2 = this.a.O;
                            afVar2.setPriority(3);
                            afVar3 = this.a.O;
                            afVar3.execute(new String[0]);
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
        com.baidu.adp.lib.util.f.a("Register2Activity", "mButtonBack", "onClick");
    }
}
