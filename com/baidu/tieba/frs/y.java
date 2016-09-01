package com.baidu.tieba.frs;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.ai;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
class y implements ai.a {
    final /* synthetic */ FrsActivity bQp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(FrsActivity frsActivity) {
        this.bQp = frsActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.ai.a
    public void hu(String str) {
        boolean z;
        com.baidu.tbadk.core.data.bg bgVar;
        com.baidu.tbadk.core.data.bg bgVar2;
        int i = 1;
        z = this.bQp.bOX;
        if (z) {
            bgVar = this.bQp.bOW;
            if (bgVar != null) {
                bgVar2 = this.bQp.bOW;
                if (bgVar2.rt().getIsLike() == 1) {
                    i = 0;
                }
            }
            this.bQp.hO(i);
        }
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_RECORDER_RESET_CMD));
    }

    @Override // com.baidu.tieba.tbadkCore.ai.a
    public void v(int i, String str) {
        boolean z;
        z = this.bQp.bOX;
        if (z && !TextUtils.isEmpty(str)) {
            if (AntiHelper.rG(i)) {
                AntiHelper.R(this.bQp.getPageContext().getPageActivity(), str);
            } else {
                this.bQp.showToast(str);
            }
        }
    }
}
