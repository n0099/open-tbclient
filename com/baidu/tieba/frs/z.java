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
    private final /* synthetic */ com.baidu.tbadk.core.data.x aVF;
    final /* synthetic */ FrsActivity aVz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(FrsActivity frsActivity, com.baidu.tbadk.core.data.x xVar) {
        this.aVz = frsActivity;
        this.aVF = xVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        String str;
        boolean z;
        bi biVar;
        cVar.dismiss();
        switch (i) {
            case 0:
                str = this.aVz.mThreadId;
                if (str != null) {
                    FrsActivity frsActivity = this.aVz;
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(this.aVz.getPageContext().getPageActivity());
                    com.baidu.tbadk.core.data.x xVar = this.aVF;
                    String str2 = this.aVz.aUF;
                    z = this.aVz.aUJ;
                    frsActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createFromThreadCfg(xVar, str2, null, 18003, true, false, z)));
                    break;
                }
                break;
            case 1:
                this.aVz.c(this.aVF);
                break;
            case 2:
                this.aVz.d(this.aVF);
                break;
        }
        com.baidu.tieba.tbadkCore.util.m readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
        if (readThreadHistory != null && this.aVF != null && !readThreadHistory.lj(this.aVF.getId())) {
            readThreadHistory.li(this.aVF.getId());
        }
        biVar = this.aVz.aUL;
        biVar.LR();
    }
}
