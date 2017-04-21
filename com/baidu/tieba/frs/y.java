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
    final /* synthetic */ FrsActivity bQa;
    private final /* synthetic */ com.baidu.tbadk.core.data.bi bQd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(FrsActivity frsActivity, com.baidu.tbadk.core.data.bi biVar) {
        this.bQa = frsActivity;
        this.bQd = biVar;
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
                str3 = this.bQa.mThreadId;
                if (str3 != null) {
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(this.bQa.getPageContext().getPageActivity());
                    com.baidu.tbadk.core.data.bi biVar = this.bQd;
                    String str4 = this.bQa.bOL;
                    z3 = this.bQa.bOS;
                    PbActivityConfig createFromThreadCfg = pbActivityConfig.createFromThreadCfg(biVar, str4, null, 18003, true, false, z3);
                    createFromThreadCfg.setVideo_source("frs");
                    this.bQa.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                    break;
                }
                break;
            case 1:
                FrsActivity frsActivity = this.bQa;
                str2 = this.bQa.mThreadId;
                com.baidu.tbadk.core.data.bi biVar2 = this.bQd;
                z2 = this.bQa.bOS;
                com.baidu.tieba.frs.f.t.a(frsActivity, str2, biVar2, z2);
                break;
            case 2:
                FrsActivity frsActivity2 = this.bQa;
                str = this.bQa.mThreadId;
                com.baidu.tbadk.core.data.bi biVar3 = this.bQd;
                z = this.bQa.bOS;
                com.baidu.tieba.frs.f.t.b(frsActivity2, str, biVar3, z);
                break;
        }
        com.baidu.tieba.tbadkCore.util.r readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
        if (readThreadHistory != null && this.bQd != null && !readThreadHistory.qp(this.bQd.getId())) {
            readThreadHistory.qo(this.bQd.getId());
        }
        this.bQa.bOU.aaW();
    }
}
