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
    private final /* synthetic */ com.baidu.tbadk.core.data.x aVF;
    final /* synthetic */ FrsGoodActivity aZI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(FrsGoodActivity frsGoodActivity, com.baidu.tbadk.core.data.x xVar) {
        this.aZI = frsGoodActivity;
        this.aVF = xVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        String str;
        String str2;
        boolean z;
        cVar.dismiss();
        switch (i) {
            case 0:
                str = this.aZI.mThreadId;
                if (str != null) {
                    FrsGoodActivity frsGoodActivity = this.aZI;
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(this.aZI.getPageContext().getPageActivity());
                    com.baidu.tbadk.core.data.x xVar = this.aVF;
                    str2 = this.aZI.aUF;
                    z = this.aZI.aUJ;
                    frsGoodActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createFromThreadCfg(xVar, str2, null, 18003, true, false, z)));
                    break;
                }
                break;
            case 1:
                this.aZI.c(this.aVF);
                break;
            case 2:
                this.aZI.d(this.aVF);
                break;
        }
        com.baidu.tieba.tbadkCore.util.m readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
        if (readThreadHistory != null && this.aVF != null && !readThreadHistory.lj(this.aVF.getId())) {
            readThreadHistory.li(this.aVF.getId());
        }
        this.aZI.aZC.LR();
    }
}
