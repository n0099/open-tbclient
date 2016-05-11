package com.baidu.tbadk.vcode;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.u;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.coreExtra.data.o;
import com.baidu.tieba.graffiti.k;
import com.baidu.tieba.graffiti.q;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class b implements q {
    final /* synthetic */ CommonVcodeActivity aAJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(CommonVcodeActivity commonVcodeActivity) {
        this.aAJ = commonVcodeActivity;
    }

    @Override // com.baidu.tieba.graffiti.q
    public void a(String str, String str2, String str3, u uVar) {
        View view;
        view = this.aAJ.aAt;
        view.setVisibility(8);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GRAFFITI_SEND_SUCCESS, new k(str2, str3, uVar)));
        this.aAJ.showToast(this.aAJ.getResources().getString(t.j.graffiti_send_succ));
        this.aAJ.setResult(-1);
        this.aAJ.closeActivity();
    }

    @Override // com.baidu.tieba.graffiti.q
    public void a(int i, String str, o oVar, String str2, String str3, String str4, int i2, int i3, String str5) {
        View view;
        h hVar;
        h hVar2;
        view = this.aAJ.aAt;
        view.setVisibility(8);
        if (StringUtils.isNull(str)) {
            hVar2 = this.aAJ.aAx;
            hVar2.d(this.aAJ.getResources().getString(t.j.input_vcode_error));
        } else {
            hVar = this.aAJ.aAx;
            hVar.d(str);
        }
        this.aAJ.FJ();
    }
}
