package com.baidu.tieba.account;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
/* loaded from: classes.dex */
class v implements View.OnClickListener {
    final /* synthetic */ Register2Activity aoa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(Register2Activity register2Activity) {
        this.aoa = register2Activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        TextView textView;
        TextView textView2;
        Button button;
        ImageView imageView;
        ImageView imageView2;
        RelativeLayout relativeLayout;
        ImageView imageView3;
        aa aaVar;
        com.baidu.tbadk.core.data.n nVar;
        com.baidu.tbadk.core.data.n nVar2;
        aa aaVar2;
        Button button2;
        ab abVar;
        aa aaVar3;
        ab abVar2;
        ab abVar3;
        aa aaVar4;
        EditText editText;
        EditText editText2;
        view2 = this.aoa.Qk;
        if (view != view2) {
            textView2 = this.aoa.anx;
            if (view != textView2) {
                button = this.aoa.any;
                if (view != button) {
                    imageView = this.aoa.anz;
                    if (view != imageView) {
                        imageView2 = this.aoa.anA;
                        if (view == imageView2) {
                            editText = this.aoa.anJ;
                            editText.setText((CharSequence) null);
                            return;
                        }
                        relativeLayout = this.aoa.anK;
                        if (view != relativeLayout) {
                            imageView3 = this.aoa.Qf;
                            if (view != imageView3) {
                                button2 = this.aoa.anB;
                                if (view != button2) {
                                    return;
                                }
                            }
                            aaVar = this.aoa.anV;
                            if (aaVar == null) {
                                nVar = this.aoa.anX;
                                if (nVar != null) {
                                    Register2Activity register2Activity = this.aoa;
                                    Register2Activity register2Activity2 = this.aoa;
                                    nVar2 = this.aoa.anX;
                                    register2Activity.anV = new aa(register2Activity2, nVar2.mK().getVcode_pic_url());
                                    aaVar2 = this.aoa.anV;
                                    aaVar2.execute(new String[0]);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        abVar = this.aoa.anW;
                        if (abVar == null) {
                            aaVar3 = this.aoa.anV;
                            if (aaVar3 != null) {
                                aaVar4 = this.aoa.anV;
                                aaVar4.cancel();
                            }
                            this.aoa.anW = new ab(this.aoa, null);
                            abVar2 = this.aoa.anW;
                            abVar2.setPriority(3);
                            abVar3 = this.aoa.anW;
                            abVar3.execute(new String[0]);
                            return;
                        }
                        return;
                    }
                    editText2 = this.aoa.anH;
                    editText2.setText((CharSequence) null);
                    return;
                }
                this.aoa.AV();
                return;
            }
        }
        textView = this.aoa.anx;
        if (view == textView) {
            this.aoa.setResult(0);
        }
        this.aoa.finish();
    }
}
