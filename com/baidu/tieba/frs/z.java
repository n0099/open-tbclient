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
    private final /* synthetic */ com.baidu.tbadk.core.data.v aUF;
    final /* synthetic */ FrsActivity aUz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(FrsActivity frsActivity, com.baidu.tbadk.core.data.v vVar) {
        this.aUz = frsActivity;
        this.aUF = vVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        String str;
        boolean z;
        bs bsVar;
        cVar.dismiss();
        switch (i) {
            case 0:
                str = this.aUz.mThreadId;
                if (str != null) {
                    FrsActivity frsActivity = this.aUz;
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(this.aUz.getPageContext().getPageActivity());
                    com.baidu.tbadk.core.data.v vVar = this.aUF;
                    String str2 = this.aUz.aTB;
                    z = this.aUz.aTH;
                    frsActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createFromThreadCfg(vVar, str2, null, 18003, true, false, z)));
                    break;
                }
                break;
            case 1:
                this.aUz.b(this.aUF);
                break;
            case 2:
                this.aUz.c(this.aUF);
                break;
        }
        com.baidu.tieba.tbadkCore.util.p readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
        if (readThreadHistory != null && this.aUF != null && !readThreadHistory.lI(this.aUF.getId())) {
            readThreadHistory.lH(this.aUF.getId());
        }
        bsVar = this.aUz.aTJ;
        bsVar.LQ();
    }
}
