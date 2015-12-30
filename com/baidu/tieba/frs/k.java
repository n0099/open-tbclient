package com.baidu.tieba.frs;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.af;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
class k implements af.a {
    final /* synthetic */ FrsActivity bed;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(FrsActivity frsActivity) {
        this.bed = frsActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.af.a
    public void gx(String str) {
        boolean z;
        com.baidu.tbadk.core.data.z zVar;
        com.baidu.tbadk.core.data.z zVar2;
        int i = 1;
        z = this.bed.bbV;
        if (z) {
            zVar = this.bed.bcY;
            if (zVar != null) {
                zVar2 = this.bed.bcY;
                if (zVar2.getPraise().getIsLike() == 1) {
                    i = 0;
                }
            }
            this.bed.fP(i);
        }
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_RECORDER_RESET_CMD));
    }

    @Override // com.baidu.tieba.tbadkCore.af.a
    public void y(int i, String str) {
        boolean z;
        z = this.bed.bbV;
        if (z && !TextUtils.isEmpty(str)) {
            if (AntiHelper.ne(i)) {
                AntiHelper.Q(this.bed.getPageContext().getPageActivity(), str);
            } else {
                this.bed.showToast(str);
            }
        }
    }
}
