package com.baidu.tieba.frs.b;

import android.app.Activity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.fb;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends com.baidu.adp.base.g {
    final /* synthetic */ a bmZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.bmZ = aVar;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        FrsActivity frsActivity;
        SignData signData;
        boolean z;
        fb fbVar;
        fb fbVar2;
        FrsActivity frsActivity2;
        fb fbVar3;
        fb fbVar4;
        fb fbVar5;
        FrsActivity frsActivity3;
        FrsActivity frsActivity4;
        fb fbVar6;
        frsActivity = this.bmZ.blE;
        com.baidu.tieba.tbadkCore.p Nn = frsActivity.Nn();
        if (Nn != null && Nn.akG() != null) {
            String name = Nn.akG().getName();
            if (obj == null || !(obj instanceof SignData)) {
                signData = null;
                z = false;
            } else {
                signData = (SignData) obj;
                com.baidu.tieba.tbadkCore.d.aDI().I(name, false);
                Nn.d(signData);
                signData.setForumId(Nn.akG().getId());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
                z = true;
            }
            this.bmZ.PO();
            if (!z) {
                fbVar = this.bmZ.bmS;
                if (!AntiHelper.ne(fbVar.getErrorCode())) {
                    fbVar2 = this.bmZ.bmS;
                    if (fbVar2.getErrorCode() == 160002) {
                        this.bmZ.gz(1);
                    }
                    frsActivity2 = this.bmZ.blE;
                    fbVar3 = this.bmZ.bmS;
                    frsActivity2.showToast(fbVar3.getErrorString());
                    return;
                }
                Activity pageActivity = this.bmZ.getPageContext().getPageActivity();
                fbVar4 = this.bmZ.bmS;
                AntiHelper.Q(pageActivity, fbVar4.getErrorString());
            } else if (Nn != null && Nn.akG() != null) {
                this.bmZ.e(Nn);
                if (signData != null) {
                    int i = -1;
                    if (this.bmZ.PU()) {
                        i = Nn.akG().getUser_level() + 1;
                    }
                    TbadkCoreApplication.m411getInst().addSignedForum(Nn.akG().getName(), signData.getBonusPoint(), i);
                }
                fbVar5 = this.bmZ.bmS;
                if (AntiHelper.ne(fbVar5.getErrorCode())) {
                    Activity pageActivity2 = this.bmZ.getPageContext().getPageActivity();
                    fbVar6 = this.bmZ.bmS;
                    AntiHelper.Q(pageActivity2, fbVar6.getErrorString());
                } else if (signData != null) {
                    if (!this.bmZ.PM()) {
                        frsActivity4 = this.bmZ.blE;
                        frsActivity4.showToast(this.bmZ.getPageContext().getResources().getString(n.j.frs_sign_success, Integer.valueOf(signData.getUserSignRank())));
                        return;
                    }
                    frsActivity3 = this.bmZ.blE;
                    frsActivity3.showToast(this.bmZ.getPageContext().getResources().getString(n.j.frs_sign_pointer, Integer.valueOf(signData.getBonusPoint()), Integer.valueOf(signData.getUserSignRank())));
                }
            }
        }
    }
}
