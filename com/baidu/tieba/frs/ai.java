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
    final /* synthetic */ FrsActivity bEL;
    private final /* synthetic */ com.baidu.tbadk.core.data.be bET;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(FrsActivity frsActivity, com.baidu.tbadk.core.data.be beVar) {
        this.bEL = frsActivity;
        this.bET = beVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        String str;
        boolean z;
        bq bqVar;
        cVar.dismiss();
        switch (i) {
            case 0:
                str = this.bEL.mThreadId;
                if (str != null) {
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(this.bEL.getPageContext().getPageActivity());
                    com.baidu.tbadk.core.data.be beVar = this.bET;
                    String str2 = this.bEL.bDB;
                    z = this.bEL.bDI;
                    PbActivityConfig createFromThreadCfg = pbActivityConfig.createFromThreadCfg(beVar, str2, null, 18003, true, false, z);
                    createFromThreadCfg.setVideo_source("frs");
                    this.bEL.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                    break;
                }
                break;
            case 1:
                this.bEL.e(this.bET);
                break;
            case 2:
                this.bEL.f(this.bET);
                break;
        }
        com.baidu.tieba.tbadkCore.util.s readThreadHistory = TbadkCoreApplication.m10getInst().getReadThreadHistory();
        if (readThreadHistory != null && this.bET != null && !readThreadHistory.qv(this.bET.getId())) {
            readThreadHistory.qu(this.bET.getId());
        }
        bqVar = this.bEL.bDK;
        bqVar.WC();
    }
}
