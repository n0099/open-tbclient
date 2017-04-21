package com.baidu.tieba.frs.mc;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.PraiseModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements PraiseModel.a {
    final /* synthetic */ s caK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(s sVar) {
        this.caK = sVar;
    }

    @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
    public void hm(String str) {
        boolean z;
        bi biVar;
        bi biVar2;
        int i = 1;
        z = this.caK.bXw;
        if (z) {
            biVar = this.caK.caI;
            if (biVar != null) {
                biVar2 = this.caK.caI;
                if (biVar2.se().getIsLike() == 1) {
                    i = 0;
                }
            }
            this.caK.io(i);
        }
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_RECORDER_RESET_CMD));
    }

    @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
    public void w(int i, String str) {
        boolean z;
        z = this.caK.bXw;
        if (z && !TextUtils.isEmpty(str)) {
            if (AntiHelper.sd(i)) {
                AntiHelper.aq(this.caK.bVk.getPageContext().getPageActivity(), str);
            } else {
                this.caK.bVk.showToast(str);
            }
        }
    }
}
