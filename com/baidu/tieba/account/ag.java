package com.baidu.tieba.account;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
/* loaded from: classes.dex */
class ag implements View.OnClickListener {
    final /* synthetic */ Register2Activity axQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(Register2Activity register2Activity) {
        this.axQ = register2Activity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.account.Register2Activity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        TextView textView;
        Button button;
        ImageView imageView;
        ImageView imageView2;
        RelativeLayout relativeLayout;
        ImageView imageView3;
        al alVar;
        com.baidu.tbadk.core.data.n nVar;
        com.baidu.tbadk.core.data.n nVar2;
        al alVar2;
        Button button2;
        am amVar;
        al alVar3;
        am amVar2;
        am amVar3;
        al alVar4;
        EditText editText;
        EditText editText2;
        int i;
        view2 = this.axQ.axj;
        if (view != view2) {
            textView = this.axQ.axk;
            if (view == textView) {
                i = this.axQ.mFrom;
                if (i == 1) {
                    this.axQ.finish();
                    return;
                } else {
                    TbadkCoreApplication.m411getInst().login(this.axQ.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) this.axQ.getPageContext().getPageActivity(), 2, true, 11038)));
                    return;
                }
            }
            button = this.axQ.axl;
            if (view != button) {
                imageView = this.axQ.axm;
                if (view != imageView) {
                    imageView2 = this.axQ.axn;
                    if (view == imageView2) {
                        editText = this.axQ.axx;
                        editText.setText((CharSequence) null);
                        return;
                    }
                    relativeLayout = this.axQ.axz;
                    if (view != relativeLayout) {
                        imageView3 = this.axQ.axG;
                        if (view != imageView3) {
                            button2 = this.axQ.axo;
                            if (view != button2) {
                                return;
                            }
                        }
                        alVar = this.axQ.axL;
                        if (alVar == null) {
                            nVar = this.axQ.axN;
                            if (nVar != null) {
                                Register2Activity register2Activity = this.axQ;
                                Register2Activity register2Activity2 = this.axQ;
                                nVar2 = this.axQ.axN;
                                register2Activity.axL = new al(register2Activity2, nVar2.qK().getVcode_pic_url());
                                alVar2 = this.axQ.axL;
                                alVar2.execute(new String[0]);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    amVar = this.axQ.axM;
                    if (amVar == null) {
                        alVar3 = this.axQ.axL;
                        if (alVar3 != null) {
                            alVar4 = this.axQ.axL;
                            alVar4.cancel();
                        }
                        this.axQ.axM = new am(this.axQ, null);
                        amVar2 = this.axQ.axM;
                        amVar2.setPriority(3);
                        amVar3 = this.axQ.axM;
                        amVar3.execute(new String[0]);
                        return;
                    }
                    return;
                }
                editText2 = this.axQ.axv;
                editText2.setText((CharSequence) null);
                return;
            }
            this.axQ.Fj();
            return;
        }
        this.axQ.finish();
    }
}
