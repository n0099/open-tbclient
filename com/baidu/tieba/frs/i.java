package com.baidu.tieba.frs;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.ae;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
class i implements ae.a {
    final /* synthetic */ FrsActivity aUz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(FrsActivity frsActivity) {
        this.aUz = frsActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.ae.a
    public void ge(String str) {
        boolean z;
        com.baidu.tbadk.core.data.v vVar;
        com.baidu.tbadk.core.data.v vVar2;
        int i = 1;
        z = this.aUz.aSo;
        if (z) {
            vVar = this.aUz.aTv;
            if (vVar != null) {
                vVar2 = this.aUz.aTv;
                if (vVar2.getPraise().getIsLike() == 1) {
                    i = 0;
                }
            }
            this.aUz.fp(i);
        }
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_RECORDER_RESET_CMD));
    }

    @Override // com.baidu.tieba.tbadkCore.ae.a
    public void y(int i, String str) {
        boolean z;
        z = this.aUz.aSo;
        if (z && !TextUtils.isEmpty(str)) {
            if (AntiHelper.la(i)) {
                AntiHelper.P(this.aUz.getPageContext().getPageActivity(), str);
            } else {
                this.aUz.showToast(str);
            }
        }
    }
}
