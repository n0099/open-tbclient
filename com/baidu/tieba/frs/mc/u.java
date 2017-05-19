package com.baidu.tieba.frs.mc;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.PraiseModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements PraiseModel.a {
    final /* synthetic */ s bYC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(s sVar) {
        this.bYC = sVar;
    }

    @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
    public void hk(String str) {
        boolean z;
        bk bkVar;
        bk bkVar2;
        int i = 1;
        z = this.bYC.bVu;
        if (z) {
            bkVar = this.bYC.bYA;
            if (bkVar != null) {
                bkVar2 = this.bYC.bYA;
                if (bkVar2.ro().getIsLike() == 1) {
                    i = 0;
                }
            }
            this.bYC.ie(i);
        }
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_RECORDER_RESET_CMD));
    }

    @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
    public void x(int i, String str) {
        boolean z;
        z = this.bYC.bVu;
        if (z && !TextUtils.isEmpty(str)) {
            if (AntiHelper.rV(i)) {
                AntiHelper.aq(this.bYC.bNK.getPageContext().getPageActivity(), str);
            } else {
                this.bYC.bNK.showToast(str);
            }
        }
    }
}
