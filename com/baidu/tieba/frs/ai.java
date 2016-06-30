package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements c.b {
    final /* synthetic */ FrsActivity bDB;
    private final /* synthetic */ com.baidu.tbadk.core.data.az bDJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(FrsActivity frsActivity, com.baidu.tbadk.core.data.az azVar) {
        this.bDB = frsActivity;
        this.bDJ = azVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        String str;
        boolean z;
        bq bqVar;
        cVar.dismiss();
        switch (i) {
            case 0:
                str = this.bDB.mThreadId;
                if (str != null) {
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(this.bDB.getPageContext().getPageActivity());
                    com.baidu.tbadk.core.data.az azVar = this.bDJ;
                    String str2 = this.bDB.bCu;
                    z = this.bDB.bCB;
                    PbActivityConfig createFromThreadCfg = pbActivityConfig.createFromThreadCfg(azVar, str2, null, 18003, true, false, z);
                    createFromThreadCfg.setVideo_source("frs");
                    this.bDB.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                    break;
                }
                break;
            case 1:
                this.bDB.e(this.bDJ);
                break;
            case 2:
                this.bDB.f(this.bDJ);
                break;
        }
        com.baidu.tieba.tbadkCore.util.s readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
        if (readThreadHistory != null && this.bDJ != null && !readThreadHistory.pL(this.bDJ.getId())) {
            readThreadHistory.pK(this.bDJ.getId());
        }
        bqVar = this.bDB.bCD;
        bqVar.Wl();
    }
}
