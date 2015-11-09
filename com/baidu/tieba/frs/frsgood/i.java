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
    private final /* synthetic */ com.baidu.tbadk.core.data.w aUY;
    final /* synthetic */ FrsGoodActivity baf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(FrsGoodActivity frsGoodActivity, com.baidu.tbadk.core.data.w wVar) {
        this.baf = frsGoodActivity;
        this.aUY = wVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        String str;
        String str2;
        boolean z;
        cVar.dismiss();
        switch (i) {
            case 0:
                str = this.baf.mThreadId;
                if (str != null) {
                    FrsGoodActivity frsGoodActivity = this.baf;
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(this.baf.getPageContext().getPageActivity());
                    com.baidu.tbadk.core.data.w wVar = this.aUY;
                    str2 = this.baf.aTU;
                    z = this.baf.aUa;
                    frsGoodActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createFromThreadCfg(wVar, str2, null, 18003, true, false, z)));
                    break;
                }
                break;
            case 1:
                this.baf.b(this.aUY);
                break;
            case 2:
                this.baf.c(this.aUY);
                break;
        }
        com.baidu.tieba.tbadkCore.util.p readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
        if (readThreadHistory != null && this.aUY != null && !readThreadHistory.lR(this.aUY.getId())) {
            readThreadHistory.lQ(this.aUY.getId());
        }
        this.baf.aZZ.Mc();
    }
}
