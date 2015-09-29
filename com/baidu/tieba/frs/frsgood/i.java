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
    private final /* synthetic */ com.baidu.tbadk.core.data.v aUF;
    final /* synthetic */ FrsGoodActivity aZB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(FrsGoodActivity frsGoodActivity, com.baidu.tbadk.core.data.v vVar) {
        this.aZB = frsGoodActivity;
        this.aUF = vVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        String str;
        String str2;
        boolean z;
        cVar.dismiss();
        switch (i) {
            case 0:
                str = this.aZB.mThreadId;
                if (str != null) {
                    FrsGoodActivity frsGoodActivity = this.aZB;
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(this.aZB.getPageContext().getPageActivity());
                    com.baidu.tbadk.core.data.v vVar = this.aUF;
                    str2 = this.aZB.aTB;
                    z = this.aZB.aTH;
                    frsGoodActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createFromThreadCfg(vVar, str2, null, 18003, true, false, z)));
                    break;
                }
                break;
            case 1:
                this.aZB.b(this.aUF);
                break;
            case 2:
                this.aZB.c(this.aUF);
                break;
        }
        com.baidu.tieba.tbadkCore.util.p readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
        if (readThreadHistory != null && this.aUF != null && !readThreadHistory.lI(this.aUF.getId())) {
            readThreadHistory.lH(this.aUF.getId());
        }
        this.aZB.aZv.LQ();
    }
}
