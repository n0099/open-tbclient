package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements c.b {
    final /* synthetic */ FrsActivity bNJ;
    private final /* synthetic */ com.baidu.tbadk.core.data.bi bNM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(FrsActivity frsActivity, com.baidu.tbadk.core.data.bi biVar) {
        this.bNJ = frsActivity;
        this.bNM = biVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        String str;
        boolean z;
        String str2;
        boolean z2;
        String str3;
        boolean z3;
        cVar.dismiss();
        switch (i) {
            case 0:
                str3 = this.bNJ.mThreadId;
                if (str3 != null) {
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(this.bNJ.getPageContext().getPageActivity());
                    com.baidu.tbadk.core.data.bi biVar = this.bNM;
                    String str4 = this.bNJ.bMu;
                    z3 = this.bNJ.bMB;
                    PbActivityConfig createFromThreadCfg = pbActivityConfig.createFromThreadCfg(biVar, str4, null, 18003, true, false, z3);
                    createFromThreadCfg.setVideo_source("frs");
                    this.bNJ.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                    break;
                }
                break;
            case 1:
                FrsActivity frsActivity = this.bNJ;
                str2 = this.bNJ.mThreadId;
                com.baidu.tbadk.core.data.bi biVar2 = this.bNM;
                z2 = this.bNJ.bMB;
                com.baidu.tieba.frs.f.t.a(frsActivity, str2, biVar2, z2);
                break;
            case 2:
                FrsActivity frsActivity2 = this.bNJ;
                str = this.bNJ.mThreadId;
                com.baidu.tbadk.core.data.bi biVar3 = this.bNM;
                z = this.bNJ.bMB;
                com.baidu.tieba.frs.f.t.b(frsActivity2, str, biVar3, z);
                break;
        }
        com.baidu.tieba.tbadkCore.util.r readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
        if (readThreadHistory != null && this.bNM != null && !readThreadHistory.qo(this.bNM.getId())) {
            readThreadHistory.qn(this.bNM.getId());
        }
        this.bNJ.bMD.ZV();
    }
}
