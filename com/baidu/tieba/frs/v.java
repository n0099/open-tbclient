package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements com.baidu.tbadk.core.dialog.h {
    final /* synthetic */ FrsActivity aJG;
    private final /* synthetic */ com.baidu.tbadk.core.data.w aJM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(FrsActivity frsActivity, com.baidu.tbadk.core.data.w wVar) {
        this.aJG = frsActivity;
        this.aJM = wVar;
    }

    @Override // com.baidu.tbadk.core.dialog.h
    public void itemClick(com.baidu.tbadk.core.dialog.e eVar, int i, View view) {
        String str;
        String str2;
        boolean z;
        bf bfVar;
        eVar.dismiss();
        switch (i) {
            case 0:
                str = this.aJG.mThreadId;
                if (str != null) {
                    FrsActivity frsActivity = this.aJG;
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(this.aJG.getPageContext().getPageActivity());
                    com.baidu.tbadk.core.data.w wVar = this.aJM;
                    str2 = this.aJG.aIK;
                    z = this.aJG.aIQ;
                    frsActivity.sendMessage(new CustomMessage(2004001, pbActivityConfig.createFromThreadCfg(wVar, str2, null, 18003, true, false, z)));
                    break;
                }
                break;
            case 1:
                this.aJG.b(this.aJM);
                break;
            case 2:
                this.aJG.c(this.aJM);
                break;
        }
        com.baidu.tieba.tbadkCore.util.l readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
        if (readThreadHistory != null && this.aJM != null && !readThreadHistory.iO(this.aJM.getId())) {
            readThreadHistory.iN(this.aJM.getId());
        }
        bfVar = this.aJG.aIS;
        bfVar.Kb();
    }
}
