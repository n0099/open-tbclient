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
    final /* synthetic */ FrsActivity bNU;
    private final /* synthetic */ com.baidu.tbadk.core.data.bj bNX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(FrsActivity frsActivity, com.baidu.tbadk.core.data.bj bjVar) {
        this.bNU = frsActivity;
        this.bNX = bjVar;
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
                str3 = this.bNU.mThreadId;
                if (str3 != null) {
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(this.bNU.getPageContext().getPageActivity());
                    com.baidu.tbadk.core.data.bj bjVar = this.bNX;
                    String str4 = this.bNU.bME;
                    z3 = this.bNU.bML;
                    PbActivityConfig createFromThreadCfg = pbActivityConfig.createFromThreadCfg(bjVar, str4, null, 18003, true, false, z3);
                    createFromThreadCfg.setVideo_source("frs");
                    this.bNU.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                    break;
                }
                break;
            case 1:
                FrsActivity frsActivity = this.bNU;
                str2 = this.bNU.mThreadId;
                com.baidu.tbadk.core.data.bj bjVar2 = this.bNX;
                z2 = this.bNU.bML;
                com.baidu.tieba.frs.utils.t.a(frsActivity, str2, bjVar2, z2);
                break;
            case 2:
                FrsActivity frsActivity2 = this.bNU;
                str = this.bNU.mThreadId;
                com.baidu.tbadk.core.data.bj bjVar3 = this.bNX;
                z = this.bNU.bML;
                com.baidu.tieba.frs.utils.t.b(frsActivity2, str, bjVar3, z);
                break;
        }
        com.baidu.tieba.tbadkCore.util.r readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
        if (readThreadHistory != null && this.bNX != null && !readThreadHistory.pX(this.bNX.getId())) {
            readThreadHistory.pW(this.bNX.getId());
        }
        this.bNU.bMN.Zx();
    }
}
