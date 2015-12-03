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
    private final /* synthetic */ com.baidu.tbadk.core.data.z bak;
    final /* synthetic */ FrsGoodActivity bgy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(FrsGoodActivity frsGoodActivity, com.baidu.tbadk.core.data.z zVar) {
        this.bgy = frsGoodActivity;
        this.bak = zVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        String str;
        String str2;
        boolean z;
        cVar.dismiss();
        switch (i) {
            case 0:
                str = this.bgy.mThreadId;
                if (str != null) {
                    FrsGoodActivity frsGoodActivity = this.bgy;
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(this.bgy.getPageContext().getPageActivity());
                    com.baidu.tbadk.core.data.z zVar = this.bak;
                    str2 = this.bgy.aZi;
                    z = this.bgy.aZo;
                    frsGoodActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createFromThreadCfg(zVar, str2, null, 18003, true, false, z)));
                    break;
                }
                break;
            case 1:
                this.bgy.b(this.bak);
                break;
            case 2:
                this.bgy.c(this.bak);
                break;
        }
        com.baidu.tieba.tbadkCore.util.p readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
        if (readThreadHistory != null && this.bak != null && !readThreadHistory.mF(this.bak.getId())) {
            readThreadHistory.mE(this.bak.getId());
        }
        this.bgy.bgr.ND();
    }
}
