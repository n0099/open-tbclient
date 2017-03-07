package com.baidu.tieba.frs.mc;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.PraiseModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements PraiseModel.a {
    final /* synthetic */ q bZS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(q qVar) {
        this.bZS = qVar;
    }

    @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
    public void hi(String str) {
        boolean z;
        bj bjVar;
        bj bjVar2;
        int i = 1;
        z = this.bZS.bVr;
        if (z) {
            bjVar = this.bZS.bZQ;
            if (bjVar != null) {
                bjVar2 = this.bZS.bZQ;
                if (bjVar2.rG().getIsLike() == 1) {
                    i = 0;
                }
            }
            this.bZS.m14if(i);
        }
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_RECORDER_RESET_CMD));
    }

    @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
    public void w(int i, String str) {
        boolean z;
        z = this.bZS.bVr;
        if (z && !TextUtils.isEmpty(str)) {
            if (AntiHelper.rZ(i)) {
                AntiHelper.an(this.bZS.bTf.getPageContext().getPageActivity(), str);
            } else {
                this.bZS.bTf.showToast(str);
            }
        }
    }
}
