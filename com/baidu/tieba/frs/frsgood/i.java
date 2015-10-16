package com.baidu.tieba.frs.frsgood;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements c.b {
    private final /* synthetic */ com.baidu.tbadk.core.data.w aUQ;
    final /* synthetic */ FrsGoodActivity aZM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(FrsGoodActivity frsGoodActivity, com.baidu.tbadk.core.data.w wVar) {
        this.aZM = frsGoodActivity;
        this.aUQ = wVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        String str;
        String str2;
        boolean z;
        cVar.dismiss();
        switch (i) {
            case 0:
                str = this.aZM.mThreadId;
                if (str != null) {
                    FrsGoodActivity frsGoodActivity = this.aZM;
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(this.aZM.getPageContext().getPageActivity());
                    com.baidu.tbadk.core.data.w wVar = this.aUQ;
                    str2 = this.aZM.aTM;
                    z = this.aZM.aTS;
                    frsGoodActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createFromThreadCfg(wVar, str2, null, 18003, true, false, z)));
                    break;
                }
                break;
            case 1:
                this.aZM.b(this.aUQ);
                break;
            case 2:
                this.aZM.c(this.aUQ);
                break;
        }
        com.baidu.tieba.tbadkCore.util.p readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
        if (readThreadHistory != null && this.aUQ != null && !readThreadHistory.lL(this.aUQ.getId())) {
            readThreadHistory.lK(this.aUQ.getId());
        }
        this.aZM.aZG.LQ();
    }
}
