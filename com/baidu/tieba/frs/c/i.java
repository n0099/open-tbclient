package com.baidu.tieba.frs.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.util.PageType;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.cl;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends com.baidu.adp.base.i {
    final /* synthetic */ a aQd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(a aVar) {
        this.aQd = aVar;
    }

    @Override // com.baidu.adp.base.i
    public void c(Object obj) {
        FrsActivity frsActivity;
        SignData signData;
        boolean z;
        cl clVar;
        FrsActivity frsActivity2;
        cl clVar2;
        FrsActivity frsActivity3;
        FrsActivity frsActivity4;
        frsActivity = this.aQd.aPF;
        w KF = frsActivity.KF();
        if (KF != null && KF.aas() != null) {
            String name = KF.aas().getName();
            if (obj == null || !(obj instanceof SignData)) {
                signData = null;
                z = false;
            } else {
                signData = (SignData) obj;
                com.baidu.tieba.tbadkCore.d.amp().D(name, false);
                KF.d(signData);
                signData.setForumId(KF.aas().getId());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001228, signData));
                z = true;
            }
            this.aQd.Mn();
            if (!z) {
                clVar = this.aQd.aQc;
                if (clVar.getErrorCode() == 160002) {
                    this.aQd.fl(1);
                }
                frsActivity2 = this.aQd.aPF;
                clVar2 = this.aQd.aQc;
                frsActivity2.showToast(clVar2.getErrorString());
            } else if (KF != null && KF.aas() != null) {
                AntiData qK = KF.qK();
                this.aQd.d(KF);
                if (signData != null) {
                    int i = -1;
                    if (this.aQd.Mt()) {
                        i = KF.aas().getUser_level() + 1;
                    }
                    TbadkCoreApplication.m411getInst().addSignedForum(KF.aas().getName(), signData.getBonusPoint(), i);
                }
                if (AntiHelper.d(qK) || AntiHelper.c(qK) || AntiHelper.e(qK)) {
                    qK.setBlock_forum_name(name);
                    qK.setBlock_forum_id(KF.aas().getId());
                    qK.setUser_name(KF.getUserData().getUserName());
                    qK.setUser_id(KF.getUserData().getUserId());
                    AntiHelper.a(this.aQd.getPageContext().getPageActivity(), qK, AntiHelper.OperationType.SIGN, PageType.FRS);
                } else if (signData != null) {
                    if (!this.aQd.Ml()) {
                        frsActivity4 = this.aQd.aPF;
                        frsActivity4.showToast(this.aQd.getPageContext().getResources().getString(t.frs_sign_success, Integer.valueOf(signData.getUserSignRank())));
                        return;
                    }
                    frsActivity3 = this.aQd.aPF;
                    frsActivity3.showToast(this.aQd.getPageContext().getResources().getString(t.frs_sign_pointer, Integer.valueOf(signData.getBonusPoint()), Integer.valueOf(signData.getUserSignRank())));
                }
            }
        }
    }
}
