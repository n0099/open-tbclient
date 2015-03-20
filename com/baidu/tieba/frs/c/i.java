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
    final /* synthetic */ a aNz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(a aVar) {
        this.aNz = aVar;
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
        frsActivity = this.aNz.aNb;
        w Ju = frsActivity.Ju();
        if (Ju != null && Ju.YO() != null) {
            String name = Ju.YO().getName();
            if (obj == null || !(obj instanceof SignData)) {
                signData = null;
                z = false;
            } else {
                signData = (SignData) obj;
                com.baidu.tieba.tbadkCore.d.ako().D(name, false);
                Ju.d(signData);
                signData.setForumId(Ju.YO().getId());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001228, signData));
                z = true;
            }
            this.aNz.KV();
            if (!z) {
                cmVar = this.aNz.aNy;
                if (cmVar.getErrorCode() == 160002) {
                    this.aNz.eW(1);
                }
                frsActivity2 = this.aNz.aNb;
                cmVar2 = this.aNz.aNy;
                frsActivity2.showToast(cmVar2.getErrorString());
            } else if (Ju != null && Ju.YO() != null) {
                AntiData qe = Ju.qe();
                this.aNz.d(Ju);
                if (signData != null) {
                    int i = -1;
                    if (this.aNz.Lb()) {
                        i = Ju.YO().getUser_level() + 1;
                    }
                    TbadkCoreApplication.m411getInst().addSignedForum(Ju.YO().getName(), signData.getBonusPoint(), i);
                }
                if (AntiHelper.d(qe) || AntiHelper.c(qe) || AntiHelper.e(qe)) {
                    qe.setBlock_forum_name(name);
                    qe.setBlock_forum_id(Ju.YO().getId());
                    qe.setUser_name(Ju.getUserData().getUserName());
                    qe.setUser_id(Ju.getUserData().getUserId());
                    AntiHelper.a(this.aNz.getPageContext().getPageActivity(), qe, AntiHelper.OperationType.SIGN, PageType.FRS);
                } else if (signData != null) {
                    if (!this.aNz.KT()) {
                        frsActivity4 = this.aNz.aNb;
                        frsActivity4.showToast(this.aNz.getPageContext().getResources().getString(y.frs_sign_success, Integer.valueOf(signData.getUserSignRank())));
                        return;
                    }
                    frsActivity3 = this.aNz.aNb;
                    frsActivity3.showToast(this.aNz.getPageContext().getResources().getString(y.frs_sign_pointer, Integer.valueOf(signData.getBonusPoint()), Integer.valueOf(signData.getUserSignRank())));
                }
            }
        }
    }
}
