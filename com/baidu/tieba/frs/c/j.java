package com.baidu.tieba.frs.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.util.PageType;
import com.baidu.tieba.frs.Cdo;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends com.baidu.adp.base.g {
    final /* synthetic */ a bbT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(a aVar) {
        this.bbT = aVar;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        FrsActivity frsActivity;
        SignData signData;
        boolean z;
        Cdo cdo;
        FrsActivity frsActivity2;
        Cdo cdo2;
        FrsActivity frsActivity3;
        FrsActivity frsActivity4;
        frsActivity = this.bbT.baN;
        com.baidu.tieba.tbadkCore.o Ll = frsActivity.Ll();
        if (Ll != null && Ll.acP() != null) {
            String name = Ll.acP().getName();
            if (obj == null || !(obj instanceof SignData)) {
                signData = null;
                z = false;
            } else {
                signData = (SignData) obj;
                com.baidu.tieba.tbadkCore.d.asX().G(name, false);
                Ll.d(signData);
                signData.setForumId(Ll.acP().getId());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
                z = true;
            }
            this.bbT.Ny();
            if (!z) {
                cdo = this.bbT.bbN;
                if (cdo.getErrorCode() == 160002) {
                    this.bbT.fT(1);
                }
                frsActivity2 = this.bbT.baN;
                cdo2 = this.bbT.bbN;
                frsActivity2.showToast(cdo2.getErrorString());
            } else if (Ll != null && Ll.acP() != null) {
                AntiData rK = Ll.rK();
                this.bbT.d(Ll);
                if (signData != null) {
                    int i = -1;
                    if (this.bbT.NE()) {
                        i = Ll.acP().getUser_level() + 1;
                    }
                    TbadkCoreApplication.m411getInst().addSignedForum(Ll.acP().getName(), signData.getBonusPoint(), i);
                }
                if (AntiHelper.e(rK) || AntiHelper.d(rK) || AntiHelper.f(rK)) {
                    rK.setBlock_forum_name(name);
                    rK.setBlock_forum_id(Ll.acP().getId());
                    rK.setUser_name(Ll.getUserData().getUserName());
                    rK.setUser_id(Ll.getUserData().getUserId());
                    AntiHelper.a(this.bbT.getPageContext().getPageActivity(), rK, AntiHelper.OperationType.SIGN, PageType.FRS);
                } else if (signData != null) {
                    if (!this.bbT.Nw()) {
                        frsActivity4 = this.bbT.baN;
                        frsActivity4.showToast(this.bbT.getPageContext().getResources().getString(i.h.frs_sign_success, Integer.valueOf(signData.getUserSignRank())));
                        return;
                    }
                    frsActivity3 = this.bbT.baN;
                    frsActivity3.showToast(this.bbT.getPageContext().getResources().getString(i.h.frs_sign_pointer, Integer.valueOf(signData.getBonusPoint()), Integer.valueOf(signData.getUserSignRank())));
                }
            }
        }
    }
}
