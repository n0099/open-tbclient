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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.account.Register2Activity;
/* loaded from: classes.dex */
class z implements View.OnClickListener {
    final /* synthetic */ Register2Activity aFh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(Register2Activity register2Activity) {
        this.aFh = register2Activity;
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
        Register2Activity.a aVar;
        com.baidu.tbadk.core.data.m mVar;
        com.baidu.tbadk.core.data.m mVar2;
        Register2Activity.a aVar2;
        Button button2;
        Register2Activity.b bVar;
        Register2Activity.a aVar3;
        Register2Activity.b bVar2;
        Register2Activity.b bVar3;
        Register2Activity.a aVar4;
        EditText editText;
        EditText editText2;
        view2 = this.aFh.aEA;
        if (view != view2) {
            textView = this.aFh.aEB;
            if (view == textView) {
                if (this.aFh.mFrom == 1) {
                    this.aFh.finish();
                    return;
                } else {
                    TbadkCoreApplication.m411getInst().login(this.aFh.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) this.aFh.getPageContext().getPageActivity(), 2, true, 11038)));
                    return;
                }
            }
            button = this.aFh.aEC;
            if (view != button) {
                imageView = this.aFh.aED;
                if (view != imageView) {
                    imageView2 = this.aFh.aEE;
                    if (view == imageView2) {
                        editText = this.aFh.aEO;
                        editText.setText((CharSequence) null);
                        return;
                    }
                    relativeLayout = this.aFh.aEQ;
                    if (view != relativeLayout) {
                        if (view != this.aFh.aEX) {
                            button2 = this.aFh.aEF;
                            if (view != button2) {
                                return;
                            }
                        }
                        aVar = this.aFh.aFc;
                        if (aVar == null) {
                            mVar = this.aFh.aFe;
                            if (mVar != null) {
                                Register2Activity register2Activity = this.aFh;
                                Register2Activity register2Activity2 = this.aFh;
                                mVar2 = this.aFh.aFe;
                                register2Activity.aFc = new Register2Activity.a(mVar2.rM().getVcode_pic_url());
                                aVar2 = this.aFh.aFc;
                                aVar2.execute(new String[0]);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    bVar = this.aFh.aFd;
                    if (bVar == null) {
                        aVar3 = this.aFh.aFc;
                        if (aVar3 != null) {
                            aVar4 = this.aFh.aFc;
                            aVar4.cancel();
                        }
                        this.aFh.aFd = new Register2Activity.b(this.aFh, null);
                        bVar2 = this.aFh.aFd;
                        bVar2.setPriority(3);
                        bVar3 = this.aFh.aFd;
                        bVar3.execute(new String[0]);
                        return;
                    }
                    return;
                }
                editText2 = this.aFh.aEM;
                editText2.setText((CharSequence) null);
                return;
            }
            this.aFh.FX();
            return;
        }
        this.aFh.finish();
    }
}
