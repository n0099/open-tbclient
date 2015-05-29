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
    final /* synthetic */ Register2Activity axP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(Register2Activity register2Activity) {
        this.axP = register2Activity;
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
        view2 = this.axP.axi;
        if (view != view2) {
            textView = this.axP.axj;
            if (view == textView) {
                i = this.axP.mFrom;
                if (i == 1) {
                    this.axP.finish();
                    return;
                } else {
                    TbadkCoreApplication.m411getInst().login(this.axP.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) this.axP.getPageContext().getPageActivity(), 2, true, 11038)));
                    return;
                }
            }
            button = this.axP.axk;
            if (view != button) {
                imageView = this.axP.axl;
                if (view != imageView) {
                    imageView2 = this.axP.axm;
                    if (view == imageView2) {
                        editText = this.axP.axw;
                        editText.setText((CharSequence) null);
                        return;
                    }
                    relativeLayout = this.axP.axy;
                    if (view != relativeLayout) {
                        imageView3 = this.axP.axF;
                        if (view != imageView3) {
                            button2 = this.axP.axn;
                            if (view != button2) {
                                return;
                            }
                        }
                        alVar = this.axP.axK;
                        if (alVar == null) {
                            nVar = this.axP.axM;
                            if (nVar != null) {
                                Register2Activity register2Activity = this.axP;
                                Register2Activity register2Activity2 = this.axP;
                                nVar2 = this.axP.axM;
                                register2Activity.axK = new al(register2Activity2, nVar2.qK().getVcode_pic_url());
                                alVar2 = this.axP.axK;
                                alVar2.execute(new String[0]);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    amVar = this.axP.axL;
                    if (amVar == null) {
                        alVar3 = this.axP.axK;
                        if (alVar3 != null) {
                            alVar4 = this.axP.axK;
                            alVar4.cancel();
                        }
                        this.axP.axL = new am(this.axP, null);
                        amVar2 = this.axP.axL;
                        amVar2.setPriority(3);
                        amVar3 = this.axP.axL;
                        amVar3.execute(new String[0]);
                        return;
                    }
                    return;
                }
                editText2 = this.axP.axu;
                editText2.setText((CharSequence) null);
                return;
            }
            this.axP.Fi();
            return;
        }
        this.axP.finish();
    }
}
