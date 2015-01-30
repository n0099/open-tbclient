package com.baidu.tieba.account;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
/* loaded from: classes.dex */
class v implements View.OnClickListener {
    final /* synthetic */ Register2Activity aod;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(Register2Activity register2Activity) {
        this.aod = register2Activity;
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
        view2 = this.aod.Qn;
        if (view != view2) {
            textView2 = this.aod.anA;
            if (view != textView2) {
                button = this.aod.anB;
                if (view != button) {
                    imageView = this.aod.anC;
                    if (view != imageView) {
                        imageView2 = this.aod.anD;
                        if (view == imageView2) {
                            editText = this.aod.anM;
                            editText.setText((CharSequence) null);
                            return;
                        }
                        relativeLayout = this.aod.anN;
                        if (view != relativeLayout) {
                            imageView3 = this.aod.Qi;
                            if (view != imageView3) {
                                button2 = this.aod.anE;
                                if (view != button2) {
                                    return;
                                }
                            }
                            aaVar = this.aod.anY;
                            if (aaVar == null) {
                                nVar = this.aod.aoa;
                                if (nVar != null) {
                                    Register2Activity register2Activity = this.aod;
                                    Register2Activity register2Activity2 = this.aod;
                                    nVar2 = this.aod.aoa;
                                    register2Activity.anY = new aa(register2Activity2, nVar2.mR().getVcode_pic_url());
                                    aaVar2 = this.aod.anY;
                                    aaVar2.execute(new String[0]);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        abVar = this.aod.anZ;
                        if (abVar == null) {
                            aaVar3 = this.aod.anY;
                            if (aaVar3 != null) {
                                aaVar4 = this.aod.anY;
                                aaVar4.cancel();
                            }
                            this.aod.anZ = new ab(this.aod, null);
                            abVar2 = this.aod.anZ;
                            abVar2.setPriority(3);
                            abVar3 = this.aod.anZ;
                            abVar3.execute(new String[0]);
                            return;
                        }
                        return;
                    }
                    editText2 = this.aod.anK;
                    editText2.setText((CharSequence) null);
                    return;
                }
                this.aod.Bb();
                return;
            }
        }
        textView = this.aod.anA;
        if (view == textView) {
            this.aod.setResult(0);
        }
        this.aod.finish();
    }
}
