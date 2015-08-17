package com.baidu.tieba.frs;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.ad;
/* loaded from: classes.dex */
class i implements ad.a {
    final /* synthetic */ FrsActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(FrsActivity frsActivity) {
        this.this$0 = frsActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.ad.a
    public void fU(String str) {
        boolean z;
        com.baidu.tbadk.core.data.v vVar;
        com.baidu.tbadk.core.data.v vVar2;
        int i = 1;
        z = this.this$0.aTe;
        if (z) {
            vVar = this.this$0.aUl;
            if (vVar != null) {
                vVar2 = this.this$0.aUl;
                if (vVar2.getPraise().getIsLike() == 1) {
                    i = 0;
                }
            }
            this.this$0.fd(i);
        }
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_RECORDER_RESET_CMD));
    }

    @Override // com.baidu.tieba.tbadkCore.ad.a
    public void bF(String str) {
        boolean z;
        z = this.this$0.aTe;
        if (z && !TextUtils.isEmpty(str)) {
            this.this$0.showToast(str);
        }
    }
}
