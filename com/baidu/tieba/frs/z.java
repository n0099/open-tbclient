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
    final /* synthetic */ FrsActivity aUK;
    private final /* synthetic */ com.baidu.tbadk.core.data.w aUQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(FrsActivity frsActivity, com.baidu.tbadk.core.data.w wVar) {
        this.aUK = frsActivity;
        this.aUQ = wVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        String str;
        boolean z;
        bs bsVar;
        cVar.dismiss();
        switch (i) {
            case 0:
                str = this.aUK.mThreadId;
                if (str != null) {
                    FrsActivity frsActivity = this.aUK;
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(this.aUK.getPageContext().getPageActivity());
                    com.baidu.tbadk.core.data.w wVar = this.aUQ;
                    String str2 = this.aUK.aTM;
                    z = this.aUK.aTS;
                    frsActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createFromThreadCfg(wVar, str2, null, 18003, true, false, z)));
                    break;
                }
                break;
            case 1:
                this.aUK.b(this.aUQ);
                break;
            case 2:
                this.aUK.c(this.aUQ);
                break;
        }
        com.baidu.tieba.tbadkCore.util.p readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
        if (readThreadHistory != null && this.aUQ != null && !readThreadHistory.lL(this.aUQ.getId())) {
            readThreadHistory.lK(this.aUQ.getId());
        }
        bsVar = this.aUK.aTU;
        bsVar.LM();
    }
}
