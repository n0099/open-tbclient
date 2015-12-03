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
    final /* synthetic */ a bji;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.bji = aVar;
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
        frsActivity = this.bji.bhN;
        com.baidu.tieba.tbadkCore.p MT = frsActivity.MT();
        if (MT != null && MT.ajy() != null) {
            String name = MT.ajy().getName();
            if (obj == null || !(obj instanceof SignData)) {
                signData = null;
                z = false;
            } else {
                signData = (SignData) obj;
                com.baidu.tieba.tbadkCore.d.aBA().J(name, false);
                MT.d(signData);
                signData.setForumId(MT.ajy().getId());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
                z = true;
            }
            this.bji.Pw();
            if (!z) {
                fbVar = this.bji.bjb;
                if (!AntiHelper.mC(fbVar.getErrorCode())) {
                    fbVar2 = this.bji.bjb;
                    if (fbVar2.getErrorCode() == 160002) {
                        this.bji.gG(1);
                    }
                    frsActivity2 = this.bji.bhN;
                    fbVar3 = this.bji.bjb;
                    frsActivity2.showToast(fbVar3.getErrorString());
                    return;
                }
                Activity pageActivity = this.bji.getPageContext().getPageActivity();
                fbVar4 = this.bji.bjb;
                AntiHelper.Q(pageActivity, fbVar4.getErrorString());
            } else if (MT != null && MT.ajy() != null) {
                this.bji.e(MT);
                if (signData != null) {
                    int i = -1;
                    if (this.bji.PC()) {
                        i = MT.ajy().getUser_level() + 1;
                    }
                    TbadkCoreApplication.m411getInst().addSignedForum(MT.ajy().getName(), signData.getBonusPoint(), i);
                }
                fbVar5 = this.bji.bjb;
                if (AntiHelper.mC(fbVar5.getErrorCode())) {
                    Activity pageActivity2 = this.bji.getPageContext().getPageActivity();
                    fbVar6 = this.bji.bjb;
                    AntiHelper.Q(pageActivity2, fbVar6.getErrorString());
                } else if (signData != null) {
                    if (!this.bji.Pu()) {
                        frsActivity4 = this.bji.bhN;
                        frsActivity4.showToast(this.bji.getPageContext().getResources().getString(n.i.frs_sign_success, Integer.valueOf(signData.getUserSignRank())));
                        return;
                    }
                    frsActivity3 = this.bji.bhN;
                    frsActivity3.showToast(this.bji.getPageContext().getResources().getString(n.i.frs_sign_pointer, Integer.valueOf(signData.getBonusPoint()), Integer.valueOf(signData.getUserSignRank())));
                }
            }
        }
    }
}
