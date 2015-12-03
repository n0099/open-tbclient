package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements c.b {
    final /* synthetic */ FrsActivity bag;
    private final /* synthetic */ com.baidu.tbadk.core.data.z bak;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(FrsActivity frsActivity, com.baidu.tbadk.core.data.z zVar) {
        this.bag = frsActivity;
        this.bak = zVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        String str;
        boolean z;
        cVar.dismiss();
        switch (i) {
            case 0:
                str = this.bag.mThreadId;
                if (str != null) {
                    FrsActivity frsActivity = this.bag;
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(this.bag.getPageContext().getPageActivity());
                    com.baidu.tbadk.core.data.z zVar = this.bak;
                    String str2 = this.bag.aZi;
                    z = this.bag.aZo;
                    frsActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createFromThreadCfg(zVar, str2, null, 18003, true, false, z)));
                    break;
                }
                break;
            case 1:
                this.bag.b(this.bak);
                break;
            case 2:
                this.bag.c(this.bak);
                break;
        }
        com.baidu.tieba.tbadkCore.util.p readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
        if (readThreadHistory != null && this.bak != null && !readThreadHistory.mF(this.bak.getId())) {
            readThreadHistory.mE(this.bak.getId());
        }
        this.bag.aZq.ND();
    }
}
