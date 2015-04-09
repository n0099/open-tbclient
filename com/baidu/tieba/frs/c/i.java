package com.baidu.tieba.frs.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.util.PageType;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.cm;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.w;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends com.baidu.adp.base.i {
    final /* synthetic */ a aNQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(a aVar) {
        this.aNQ = aVar;
    }

    @Override // com.baidu.adp.base.i
    public void c(Object obj) {
        FrsActivity frsActivity;
        SignData signData;
        boolean z;
        cm cmVar;
        FrsActivity frsActivity2;
        cm cmVar2;
        FrsActivity frsActivity3;
        FrsActivity frsActivity4;
        frsActivity = this.aNQ.aNs;
        w JA = frsActivity.JA();
        if (JA != null && JA.Za() != null) {
            String name = JA.Za().getName();
            if (obj == null || !(obj instanceof SignData)) {
                signData = null;
                z = false;
            } else {
                signData = (SignData) obj;
                com.baidu.tieba.tbadkCore.d.akD().D(name, false);
                JA.d(signData);
                signData.setForumId(JA.Za().getId());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001228, signData));
                z = true;
            }
            this.aNQ.Lh();
            if (!z) {
                cmVar = this.aNQ.aNP;
                if (cmVar.getErrorCode() == 160002) {
                    this.aNQ.eX(1);
                }
                frsActivity2 = this.aNQ.aNs;
                cmVar2 = this.aNQ.aNP;
                frsActivity2.showToast(cmVar2.getErrorString());
            } else if (JA != null && JA.Za() != null) {
                AntiData qe = JA.qe();
                this.aNQ.d(JA);
                if (signData != null) {
                    int i = -1;
                    if (this.aNQ.Ln()) {
                        i = JA.Za().getUser_level() + 1;
                    }
                    TbadkCoreApplication.m411getInst().addSignedForum(JA.Za().getName(), signData.getBonusPoint(), i);
                }
                if (AntiHelper.d(qe) || AntiHelper.c(qe) || AntiHelper.e(qe)) {
                    qe.setBlock_forum_name(name);
                    qe.setBlock_forum_id(JA.Za().getId());
                    qe.setUser_name(JA.getUserData().getUserName());
                    qe.setUser_id(JA.getUserData().getUserId());
                    AntiHelper.a(this.aNQ.getPageContext().getPageActivity(), qe, AntiHelper.OperationType.SIGN, PageType.FRS);
                } else if (signData != null) {
                    if (!this.aNQ.Lf()) {
                        frsActivity4 = this.aNQ.aNs;
                        frsActivity4.showToast(this.aNQ.getPageContext().getResources().getString(y.frs_sign_success, Integer.valueOf(signData.getUserSignRank())));
                        return;
                    }
                    frsActivity3 = this.aNQ.aNs;
                    frsActivity3.showToast(this.aNQ.getPageContext().getResources().getString(y.frs_sign_pointer, Integer.valueOf(signData.getBonusPoint()), Integer.valueOf(signData.getUserSignRank())));
                }
            }
        }
    }
}
