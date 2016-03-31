package com.baidu.tbadk.vcode;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.u;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.coreExtra.data.n;
import com.baidu.tieba.graffiti.k;
import com.baidu.tieba.graffiti.q;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class b implements q {
    final /* synthetic */ CommonVcodeActivity aEz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(CommonVcodeActivity commonVcodeActivity) {
        this.aEz = commonVcodeActivity;
    }

    @Override // com.baidu.tieba.graffiti.q
    public void a(String str, String str2, String str3, u uVar) {
        View view;
        view = this.aEz.aEj;
        view.setVisibility(8);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GRAFFITI_SEND_SUCCESS, new k(str2, str3, uVar)));
        this.aEz.showToast(this.aEz.getResources().getString(t.j.graffiti_send_succ));
        this.aEz.setResult(-1);
        this.aEz.closeActivity();
    }

    @Override // com.baidu.tieba.graffiti.q
    public void a(int i, String str, n nVar, String str2, String str3, String str4, int i2, int i3, String str5) {
        View view;
        h hVar;
        view = this.aEz.aEj;
        view.setVisibility(8);
        hVar = this.aEz.aEn;
        hVar.d(this.aEz.getResources().getString(t.j.input_vcode_error));
        this.aEz.HH();
    }
}
