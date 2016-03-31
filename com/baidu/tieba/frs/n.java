package com.baidu.tieba.frs;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.ae;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
class n implements ae.a {
    final /* synthetic */ FrsActivity blk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(FrsActivity frsActivity) {
        this.blk = frsActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.ae.a
    public void gJ(String str) {
        boolean z;
        com.baidu.tbadk.core.data.as asVar;
        com.baidu.tbadk.core.data.as asVar2;
        int i = 1;
        z = this.blk.biT;
        if (z) {
            asVar = this.blk.bjZ;
            if (asVar != null) {
                asVar2 = this.blk.bjZ;
                if (asVar2.getPraise().getIsLike() == 1) {
                    i = 0;
                }
            }
            this.blk.gB(i);
        }
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_RECORDER_RESET_CMD));
    }

    @Override // com.baidu.tieba.tbadkCore.ae.a
    public void q(int i, String str) {
        boolean z;
        z = this.blk.biT;
        if (z && !TextUtils.isEmpty(str)) {
            if (AntiHelper.pB(i)) {
                AntiHelper.O(this.blk.getPageContext().getPageActivity(), str);
            } else {
                this.blk.showToast(str);
            }
        }
    }
}
