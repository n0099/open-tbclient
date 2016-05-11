package com.baidu.tieba.frs;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.af;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
class r implements af.a {
    final /* synthetic */ FrsActivity bhl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(FrsActivity frsActivity) {
        this.bhl = frsActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.af.a
    public void gK(String str) {
        boolean z;
        com.baidu.tbadk.core.data.ax axVar;
        com.baidu.tbadk.core.data.ax axVar2;
        int i = 1;
        z = this.bhl.beS;
        if (z) {
            axVar = this.bhl.bfY;
            if (axVar != null) {
                axVar2 = this.bhl.bfY;
                if (axVar2.getPraise().getIsLike() == 1) {
                    i = 0;
                }
            }
            this.bhl.gh(i);
        }
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_RECORDER_RESET_CMD));
    }

    @Override // com.baidu.tieba.tbadkCore.af.a
    public void q(int i, String str) {
        boolean z;
        z = this.bhl.beS;
        if (z && !TextUtils.isEmpty(str)) {
            if (AntiHelper.pw(i)) {
                AntiHelper.O(this.bhl.getPageContext().getPageActivity(), str);
            } else {
                this.bhl.showToast(str);
            }
        }
    }
}
