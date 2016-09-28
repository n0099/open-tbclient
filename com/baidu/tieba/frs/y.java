package com.baidu.tieba.frs;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.ai;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
class y implements ai.a {
    final /* synthetic */ FrsActivity bQi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(FrsActivity frsActivity) {
        this.bQi = frsActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.ai.a
    public void hB(String str) {
        boolean z;
        com.baidu.tbadk.core.data.bi biVar;
        com.baidu.tbadk.core.data.bi biVar2;
        int i = 1;
        z = this.bQi.bOR;
        if (z) {
            biVar = this.bQi.bOQ;
            if (biVar != null) {
                biVar2 = this.bQi.bOQ;
                if (biVar2.rF().getIsLike() == 1) {
                    i = 0;
                }
            }
            this.bQi.hS(i);
        }
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_RECORDER_RESET_CMD));
    }

    @Override // com.baidu.tieba.tbadkCore.ai.a
    public void v(int i, String str) {
        boolean z;
        z = this.bQi.bOR;
        if (z && !TextUtils.isEmpty(str)) {
            if (AntiHelper.rU(i)) {
                AntiHelper.R(this.bQi.getPageContext().getPageActivity(), str);
            } else {
                this.bQi.showToast(str);
            }
        }
    }
}
