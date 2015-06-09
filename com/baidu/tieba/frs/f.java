package com.baidu.tieba.frs;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class f implements com.baidu.tieba.tbadkCore.at {
    final /* synthetic */ FrsActivity aLY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(FrsActivity frsActivity) {
        this.aLY = frsActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.at
    public void fA(String str) {
        boolean z;
        com.baidu.tbadk.core.data.w wVar;
        com.baidu.tbadk.core.data.w wVar2;
        int i = 1;
        z = this.aLY.aJQ;
        if (z) {
            wVar = this.aLY.aKY;
            if (wVar != null) {
                wVar2 = this.aLY.aKY;
                if (wVar2.getPraise().getIsLike() == 1) {
                    i = 0;
                }
            }
            this.aLY.eS(i);
        }
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004006));
    }

    @Override // com.baidu.tieba.tbadkCore.at
    public void fB(String str) {
        boolean z;
        z = this.aLY.aJQ;
        if (z && !TextUtils.isEmpty(str)) {
            this.aLY.showToast(str);
        }
    }
}
