package com.baidu.tieba.frs;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.aj;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
class v implements aj.a {
    final /* synthetic */ FrsActivity bEL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(FrsActivity frsActivity) {
        this.bEL = frsActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.aj.a
    public void gR(String str) {
        boolean z;
        com.baidu.tbadk.core.data.be beVar;
        com.baidu.tbadk.core.data.be beVar2;
        int i = 1;
        z = this.bEL.bDt;
        if (z) {
            beVar = this.bEL.bDs;
            if (beVar != null) {
                beVar2 = this.bEL.bDs;
                if (beVar2.qp().getIsLike() == 1) {
                    i = 0;
                }
            }
            this.bEL.hl(i);
        }
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_RECORDER_RESET_CMD));
    }

    @Override // com.baidu.tieba.tbadkCore.aj.a
    public void u(int i, String str) {
        boolean z;
        z = this.bEL.bDt;
        if (z && !TextUtils.isEmpty(str)) {
            if (AntiHelper.rg(i)) {
                AntiHelper.O(this.bEL.getPageContext().getPageActivity(), str);
            } else {
                this.bEL.showToast(str);
            }
        }
    }
}
