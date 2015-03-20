package com.baidu.tieba.frs;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class f implements com.baidu.tieba.tbadkCore.at {
    final /* synthetic */ FrsActivity aJG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(FrsActivity frsActivity) {
        this.aJG = frsActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.at
    public void fc(String str) {
        boolean z;
        com.baidu.tbadk.core.data.w wVar;
        com.baidu.tbadk.core.data.w wVar2;
        int i = 1;
        z = this.aJG.aHy;
        if (z) {
            wVar = this.aJG.aIH;
            if (wVar != null) {
                wVar2 = this.aJG.aIH;
                if (wVar2.getPraise().getIsLike() == 1) {
                    i = 0;
                }
            }
            this.aJG.eE(i);
        }
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004006));
    }

    @Override // com.baidu.tieba.tbadkCore.at
    public void fd(String str) {
        boolean z;
        z = this.aJG.aHy;
        if (z && !TextUtils.isEmpty(str)) {
            this.aJG.showToast(str);
        }
    }
}
