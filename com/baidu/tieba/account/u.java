package com.baidu.tieba.account;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
/* loaded from: classes.dex */
class u implements View.OnClickListener {
    final /* synthetic */ Register2Activity ani;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(Register2Activity register2Activity) {
        this.ani = register2Activity;
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
        z zVar;
        com.baidu.tbadk.core.data.m mVar;
        com.baidu.tbadk.core.data.m mVar2;
        z zVar2;
        Button button2;
        aa aaVar;
        z zVar3;
        aa aaVar2;
        aa aaVar3;
        z zVar4;
        EditText editText;
        EditText editText2;
        view2 = this.ani.PM;
        if (view != view2) {
            textView2 = this.ani.amF;
            if (view != textView2) {
                button = this.ani.amG;
                if (view != button) {
                    imageView = this.ani.amH;
                    if (view != imageView) {
                        imageView2 = this.ani.amI;
                        if (view == imageView2) {
                            editText = this.ani.amR;
                            editText.setText((CharSequence) null);
                            return;
                        }
                        relativeLayout = this.ani.amS;
                        if (view != relativeLayout) {
                            imageView3 = this.ani.PG;
                            if (view != imageView3) {
                                button2 = this.ani.amJ;
                                if (view != button2) {
                                    return;
                                }
                            }
                            zVar = this.ani.and;
                            if (zVar == null) {
                                mVar = this.ani.anf;
                                if (mVar != null) {
                                    Register2Activity register2Activity = this.ani;
                                    Register2Activity register2Activity2 = this.ani;
                                    mVar2 = this.ani.anf;
                                    register2Activity.and = new z(register2Activity2, mVar2.mP().getVcode_pic_url());
                                    zVar2 = this.ani.and;
                                    zVar2.execute(new String[0]);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        aaVar = this.ani.ane;
                        if (aaVar == null) {
                            zVar3 = this.ani.and;
                            if (zVar3 != null) {
                                zVar4 = this.ani.and;
                                zVar4.cancel();
                            }
                            this.ani.ane = new aa(this.ani, null);
                            aaVar2 = this.ani.ane;
                            aaVar2.setPriority(3);
                            aaVar3 = this.ani.ane;
                            aaVar3.execute(new String[0]);
                            return;
                        }
                        return;
                    }
                    editText2 = this.ani.amP;
                    editText2.setText((CharSequence) null);
                    return;
                }
                this.ani.AB();
                return;
            }
        }
        textView = this.ani.amF;
        if (view == textView) {
            this.ani.setResult(0);
        }
        this.ani.finish();
    }
}
