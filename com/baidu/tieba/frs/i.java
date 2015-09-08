package com.baidu.tieba.frs;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.ae;
/* loaded from: classes.dex */
class i implements ae.a {
    final /* synthetic */ FrsActivity aVz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(FrsActivity frsActivity) {
        this.aVz = frsActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.ae.a
    public void gb(String str) {
        boolean z;
        com.baidu.tbadk.core.data.x xVar;
        com.baidu.tbadk.core.data.x xVar2;
        int i = 1;
        z = this.aVz.aTs;
        if (z) {
            xVar = this.aVz.aUz;
            if (xVar != null) {
                xVar2 = this.aVz.aUz;
                if (xVar2.getPraise().getIsLike() == 1) {
                    i = 0;
                }
            }
            this.aVz.fk(i);
        }
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_RECORDER_RESET_CMD));
    }

    @Override // com.baidu.tieba.tbadkCore.ae.a
    public void bF(String str) {
        boolean z;
        z = this.aVz.aTs;
        if (z && !TextUtils.isEmpty(str)) {
            this.aVz.showToast(str);
        }
    }
}
