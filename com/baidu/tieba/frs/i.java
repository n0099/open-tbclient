package com.baidu.tieba.frs;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.ae;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
class i implements ae.a {
    final /* synthetic */ FrsActivity aUK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(FrsActivity frsActivity) {
        this.aUK = frsActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.ae.a
    public void ge(String str) {
        boolean z;
        com.baidu.tbadk.core.data.w wVar;
        com.baidu.tbadk.core.data.w wVar2;
        int i = 1;
        z = this.aUK.aSz;
        if (z) {
            wVar = this.aUK.aTG;
            if (wVar != null) {
                wVar2 = this.aUK.aTG;
                if (wVar2.getPraise().getIsLike() == 1) {
                    i = 0;
                }
            }
            this.aUK.fp(i);
        }
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_RECORDER_RESET_CMD));
    }

    @Override // com.baidu.tieba.tbadkCore.ae.a
    public void y(int i, String str) {
        boolean z;
        z = this.aUK.aSz;
        if (z && !TextUtils.isEmpty(str)) {
            if (AntiHelper.lc(i)) {
                AntiHelper.P(this.aUK.getPageContext().getPageActivity(), str);
            } else {
                this.aUK.showToast(str);
            }
        }
    }
}
