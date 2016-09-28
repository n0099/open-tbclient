package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements c.b {
    final /* synthetic */ FrsActivity bQi;
    private final /* synthetic */ com.baidu.tbadk.core.data.bi bQr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(FrsActivity frsActivity, com.baidu.tbadk.core.data.bi biVar) {
        this.bQi = frsActivity;
        this.bQr = biVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        String str;
        boolean z;
        bm bmVar;
        cVar.dismiss();
        switch (i) {
            case 0:
                str = this.bQi.mThreadId;
                if (str != null) {
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(this.bQi.getPageContext().getPageActivity());
                    com.baidu.tbadk.core.data.bi biVar = this.bQr;
                    String str2 = this.bQi.bOZ;
                    z = this.bQi.bPg;
                    PbActivityConfig createFromThreadCfg = pbActivityConfig.createFromThreadCfg(biVar, str2, null, 18003, true, false, z);
                    createFromThreadCfg.setVideo_source("frs");
                    this.bQi.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                    break;
                }
                break;
            case 1:
                this.bQi.f(this.bQr);
                break;
            case 2:
                this.bQi.g(this.bQr);
                break;
        }
        com.baidu.tieba.tbadkCore.util.s readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
        if (readThreadHistory != null && this.bQr != null && !readThreadHistory.ru(this.bQr.getId())) {
            readThreadHistory.rt(this.bQr.getId());
        }
        bmVar = this.bQi.bPi;
        bmVar.abK();
    }
}
