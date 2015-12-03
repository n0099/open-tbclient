package com.baidu.tieba.frs;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.af;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
class j implements af.a {
    final /* synthetic */ FrsActivity bag;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(FrsActivity frsActivity) {
        this.bag = frsActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.af.a
    public void gt(String str) {
        boolean z;
        com.baidu.tbadk.core.data.z zVar;
        com.baidu.tbadk.core.data.z zVar2;
        int i = 1;
        z = this.bag.aXV;
        if (z) {
            zVar = this.bag.aZc;
            if (zVar != null) {
                zVar2 = this.bag.aZc;
                if (zVar2.getPraise().getIsLike() == 1) {
                    i = 0;
                }
            }
            this.bag.fU(i);
        }
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_RECORDER_RESET_CMD));
    }

    @Override // com.baidu.tieba.tbadkCore.af.a
    public void y(int i, String str) {
        boolean z;
        z = this.bag.aXV;
        if (z && !TextUtils.isEmpty(str)) {
            if (AntiHelper.mC(i)) {
                AntiHelper.Q(this.bag.getPageContext().getPageActivity(), str);
            } else {
                this.bag.showToast(str);
            }
        }
    }
}
