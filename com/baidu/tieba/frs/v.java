package com.baidu.tieba.frs;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.aj;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
class v implements aj.a {
    final /* synthetic */ FrsActivity bDB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(FrsActivity frsActivity) {
        this.bDB = frsActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.aj.a
    public void gR(String str) {
        boolean z;
        com.baidu.tbadk.core.data.az azVar;
        com.baidu.tbadk.core.data.az azVar2;
        int i = 1;
        z = this.bDB.bBf;
        if (z) {
            azVar = this.bDB.bCn;
            if (azVar != null) {
                azVar2 = this.bDB.bCn;
                if (azVar2.getPraise().getIsLike() == 1) {
                    i = 0;
                }
            }
            this.bDB.hi(i);
        }
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_RECORDER_RESET_CMD));
    }

    @Override // com.baidu.tieba.tbadkCore.aj.a
    public void u(int i, String str) {
        boolean z;
        z = this.bDB.bBf;
        if (z && !TextUtils.isEmpty(str)) {
            if (AntiHelper.qL(i)) {
                AntiHelper.O(this.bDB.getPageContext().getPageActivity(), str);
            } else {
                this.bDB.showToast(str);
            }
        }
    }
}
