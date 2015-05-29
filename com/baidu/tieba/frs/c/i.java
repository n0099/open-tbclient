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
    final /* synthetic */ a aQc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(a aVar) {
        this.aQc = aVar;
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
        frsActivity = this.aQc.aPE;
        w KE = frsActivity.KE();
        if (KE != null && KE.aar() != null) {
            String name = KE.aar().getName();
            if (obj == null || !(obj instanceof SignData)) {
                signData = null;
                z = false;
            } else {
                signData = (SignData) obj;
                com.baidu.tieba.tbadkCore.d.amo().D(name, false);
                KE.d(signData);
                signData.setForumId(KE.aar().getId());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001228, signData));
                z = true;
            }
            this.aQc.Mm();
            if (!z) {
                clVar = this.aQc.aQb;
                if (clVar.getErrorCode() == 160002) {
                    this.aQc.fl(1);
                }
                frsActivity2 = this.aQc.aPE;
                clVar2 = this.aQc.aQb;
                frsActivity2.showToast(clVar2.getErrorString());
            } else if (KE != null && KE.aar() != null) {
                AntiData qK = KE.qK();
                this.aQc.d(KE);
                if (signData != null) {
                    int i = -1;
                    if (this.aQc.Ms()) {
                        i = KE.aar().getUser_level() + 1;
                    }
                    TbadkCoreApplication.m411getInst().addSignedForum(KE.aar().getName(), signData.getBonusPoint(), i);
                }
                if (AntiHelper.d(qK) || AntiHelper.c(qK) || AntiHelper.e(qK)) {
                    qK.setBlock_forum_name(name);
                    qK.setBlock_forum_id(KE.aar().getId());
                    qK.setUser_name(KE.getUserData().getUserName());
                    qK.setUser_id(KE.getUserData().getUserId());
                    AntiHelper.a(this.aQc.getPageContext().getPageActivity(), qK, AntiHelper.OperationType.SIGN, PageType.FRS);
                } else if (signData != null) {
                    if (!this.aQc.Mk()) {
                        frsActivity4 = this.aQc.aPE;
                        frsActivity4.showToast(this.aQc.getPageContext().getResources().getString(t.frs_sign_success, Integer.valueOf(signData.getUserSignRank())));
                        return;
                    }
                    frsActivity3 = this.aQc.aPE;
                    frsActivity3.showToast(this.aQc.getPageContext().getResources().getString(t.frs_sign_pointer, Integer.valueOf(signData.getBonusPoint()), Integer.valueOf(signData.getUserSignRank())));
                }
            }
        }
    }
}
