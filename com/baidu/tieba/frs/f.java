package com.baidu.tieba.frs;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class f implements com.baidu.tieba.tbadkCore.at {
    final /* synthetic */ FrsActivity aJQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(FrsActivity frsActivity) {
        this.aJQ = frsActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.at
    public void ff(String str) {
        boolean z;
        com.baidu.tbadk.core.data.w wVar;
        com.baidu.tbadk.core.data.w wVar2;
        int i = 1;
        z = this.aJQ.aHG;
        if (z) {
            wVar = this.aJQ.aIP;
            if (wVar != null) {
                wVar2 = this.aJQ.aIP;
                if (wVar2.getPraise().getIsLike() == 1) {
                    i = 0;
                }
            }
            this.aJQ.eE(i);
        }
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004006));
    }

    @Override // com.baidu.tieba.tbadkCore.at
    public void fg(String str) {
        boolean z;
        z = this.aJQ.aHG;
        if (z && !TextUtils.isEmpty(str)) {
            this.aJQ.showToast(str);
        }
    }
}
