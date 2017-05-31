package com.baidu.tieba.frs.mc;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.PraiseModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements PraiseModel.a {
    final /* synthetic */ s ceO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(s sVar) {
        this.ceO = sVar;
    }

    @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
    public void hg(String str) {
        boolean z;
        bl blVar;
        bl blVar2;
        int i = 1;
        z = this.ceO.cbv;
        if (z) {
            blVar = this.ceO.ceM;
            if (blVar != null) {
                blVar2 = this.ceO.ceM;
                if (blVar2.rk().getIsLike() == 1) {
                    i = 0;
                }
            }
            this.ceO.iC(i);
        }
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_RECORDER_RESET_CMD));
    }

    @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
    public void y(int i, String str) {
        boolean z;
        z = this.ceO.cbv;
        if (z && !TextUtils.isEmpty(str)) {
            if (AntiHelper.sr(i)) {
                AntiHelper.ap(this.ceO.bTw.getPageContext().getPageActivity(), str);
            } else {
                this.ceO.bTw.showToast(str);
            }
        }
    }
}
