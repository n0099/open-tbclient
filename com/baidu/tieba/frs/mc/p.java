package com.baidu.tieba.frs.mc;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.PraiseModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements PraiseModel.a {
    final /* synthetic */ n bSG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(n nVar) {
        this.bSG = nVar;
    }

    @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
    public void ht(String str) {
        boolean z;
        bh bhVar;
        bh bhVar2;
        int i = 1;
        z = this.bSG.bOj;
        if (z) {
            bhVar = this.bSG.bSE;
            if (bhVar != null) {
                bhVar2 = this.bSG.bSE;
                if (bhVar2.rn().getIsLike() == 1) {
                    i = 0;
                }
            }
            this.bSG.ij(i);
        }
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_RECORDER_RESET_CMD));
    }

    @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
    public void v(int i, String str) {
        boolean z;
        z = this.bSG.bOj;
        if (z && !TextUtils.isEmpty(str)) {
            if (AntiHelper.sa(i)) {
                AntiHelper.T(this.bSG.bLZ.getPageContext().getPageActivity(), str);
            } else {
                this.bSG.bLZ.showToast(str);
            }
        }
    }
}
