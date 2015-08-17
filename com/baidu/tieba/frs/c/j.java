package com.baidu.tieba.frs.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.util.PageType;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.di;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends com.baidu.adp.base.g {
    final /* synthetic */ a bbz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(a aVar) {
        this.bbz = aVar;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        FrsActivity frsActivity;
        SignData signData;
        boolean z;
        di diVar;
        FrsActivity frsActivity2;
        di diVar2;
        FrsActivity frsActivity3;
        FrsActivity frsActivity4;
        frsActivity = this.bbz.bat;
        com.baidu.tieba.tbadkCore.n Lu = frsActivity.Lu();
        if (Lu != null && Lu.acG() != null) {
            String name = Lu.acG().getName();
            if (obj == null || !(obj instanceof SignData)) {
                signData = null;
                z = false;
            } else {
                signData = (SignData) obj;
                com.baidu.tieba.tbadkCore.c.aoQ().E(name, false);
                Lu.d(signData);
                signData.setForumId(Lu.acG().getId());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
                z = true;
            }
            this.bbz.Nx();
            if (!z) {
                diVar = this.bbz.bbt;
                if (diVar.getErrorCode() == 160002) {
                    this.bbz.fK(1);
                }
                frsActivity2 = this.bbz.bat;
                diVar2 = this.bbz.bbt;
                frsActivity2.showToast(diVar2.getErrorString());
            } else if (Lu != null && Lu.acG() != null) {
                AntiData rM = Lu.rM();
                this.bbz.e(Lu);
                if (signData != null) {
                    int i = -1;
                    if (this.bbz.ND()) {
                        i = Lu.acG().getUser_level() + 1;
                    }
                    TbadkCoreApplication.m411getInst().addSignedForum(Lu.acG().getName(), signData.getBonusPoint(), i);
                }
                if (AntiHelper.e(rM) || AntiHelper.d(rM) || AntiHelper.f(rM)) {
                    rM.setBlock_forum_name(name);
                    rM.setBlock_forum_id(Lu.acG().getId());
                    rM.setUser_name(Lu.getUserData().getUserName());
                    rM.setUser_id(Lu.getUserData().getUserId());
                    AntiHelper.a(this.bbz.getPageContext().getPageActivity(), rM, AntiHelper.OperationType.SIGN, PageType.FRS);
                } else if (signData != null) {
                    if (!this.bbz.Nv()) {
                        frsActivity4 = this.bbz.bat;
                        frsActivity4.showToast(this.bbz.getPageContext().getResources().getString(i.C0057i.frs_sign_success, Integer.valueOf(signData.getUserSignRank())));
                        return;
                    }
                    frsActivity3 = this.bbz.bat;
                    frsActivity3.showToast(this.bbz.getPageContext().getResources().getString(i.C0057i.frs_sign_pointer, Integer.valueOf(signData.getBonusPoint()), Integer.valueOf(signData.getUserSignRank())));
                }
            }
        }
    }
}
