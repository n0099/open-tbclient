package com.baidu.tieba.frs.mc;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.PraiseModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements PraiseModel.a {
    final /* synthetic */ v cnd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(v vVar) {
        this.cnd = vVar;
    }

    @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
    public void hD(String str) {
        boolean z;
        bm bmVar;
        bm bmVar2;
        int i = 1;
        z = this.cnd.cjG;
        if (z) {
            bmVar = this.cnd.cnb;
            if (bmVar != null) {
                bmVar2 = this.cnd.cnb;
                if (bmVar2.rh().getIsLike() == 1) {
                    i = 0;
                }
            }
            this.cnd.iO(i);
        }
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_RECORDER_RESET_CMD));
    }

    @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
    public void A(int i, String str) {
        boolean z;
        z = this.cnd.cjG;
        if (z && !TextUtils.isEmpty(str)) {
            if (AntiHelper.sK(i)) {
                AntiHelper.ar(this.cnd.cbE.getPageContext().getPageActivity(), str);
            } else {
                this.cnd.cbE.showToast(str);
            }
        }
    }
}
