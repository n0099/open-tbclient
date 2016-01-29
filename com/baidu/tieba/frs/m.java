package com.baidu.tieba.frs;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.ae;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
class m implements ae.a {
    final /* synthetic */ FrsActivity bgz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(FrsActivity frsActivity) {
        this.bgz = frsActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.ae.a
    public void gx(String str) {
        boolean z;
        com.baidu.tbadk.core.data.ah ahVar;
        com.baidu.tbadk.core.data.ah ahVar2;
        int i = 1;
        z = this.bgz.beg;
        if (z) {
            ahVar = this.bgz.bfp;
            if (ahVar != null) {
                ahVar2 = this.bgz.bfp;
                if (ahVar2.getPraise().getIsLike() == 1) {
                    i = 0;
                }
            }
            this.bgz.gl(i);
        }
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_RECORDER_RESET_CMD));
    }

    @Override // com.baidu.tieba.tbadkCore.ae.a
    public void y(int i, String str) {
        boolean z;
        z = this.bgz.beg;
        if (z && !TextUtils.isEmpty(str)) {
            if (AntiHelper.or(i)) {
                AntiHelper.X(this.bgz.getPageContext().getPageActivity(), str);
            } else {
                this.bgz.showToast(str);
            }
        }
    }
}
