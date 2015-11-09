package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements c.b {
    final /* synthetic */ FrsActivity aUS;
    private final /* synthetic */ com.baidu.tbadk.core.data.w aUY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(FrsActivity frsActivity, com.baidu.tbadk.core.data.w wVar) {
        this.aUS = frsActivity;
        this.aUY = wVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        String str;
        boolean z;
        bs bsVar;
        cVar.dismiss();
        switch (i) {
            case 0:
                str = this.aUS.mThreadId;
                if (str != null) {
                    FrsActivity frsActivity = this.aUS;
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(this.aUS.getPageContext().getPageActivity());
                    com.baidu.tbadk.core.data.w wVar = this.aUY;
                    String str2 = this.aUS.aTU;
                    z = this.aUS.aUa;
                    frsActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createFromThreadCfg(wVar, str2, null, 18003, true, false, z)));
                    break;
                }
                break;
            case 1:
                this.aUS.b(this.aUY);
                break;
            case 2:
                this.aUS.c(this.aUY);
                break;
        }
        com.baidu.tieba.tbadkCore.util.p readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
        if (readThreadHistory != null && this.aUY != null && !readThreadHistory.lR(this.aUY.getId())) {
            readThreadHistory.lQ(this.aUY.getId());
        }
        bsVar = this.aUS.aUc;
        bsVar.Mc();
    }
}
