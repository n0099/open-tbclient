package com.baidu.tieba.frs;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.ae;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
class i implements ae.a {
    final /* synthetic */ FrsActivity aUS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(FrsActivity frsActivity) {
        this.aUS = frsActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.ae.a
    public void gg(String str) {
        boolean z;
        com.baidu.tbadk.core.data.w wVar;
        com.baidu.tbadk.core.data.w wVar2;
        int i = 1;
        z = this.aUS.aSH;
        if (z) {
            wVar = this.aUS.aTO;
            if (wVar != null) {
                wVar2 = this.aUS.aTO;
                if (wVar2.getPraise().getIsLike() == 1) {
                    i = 0;
                }
            }
            this.aUS.fx(i);
        }
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_RECORDER_RESET_CMD));
    }

    @Override // com.baidu.tieba.tbadkCore.ae.a
    public void x(int i, String str) {
        boolean z;
        z = this.aUS.aSH;
        if (z && !TextUtils.isEmpty(str)) {
            if (AntiHelper.lr(i)) {
                AntiHelper.Q(this.aUS.getPageContext().getPageActivity(), str);
            } else {
                this.aUS.showToast(str);
            }
        }
    }
}
