package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements c.b {
    private final /* synthetic */ com.baidu.tbadk.core.data.ah bgD;
    final /* synthetic */ FrsActivity bgz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(FrsActivity frsActivity, com.baidu.tbadk.core.data.ah ahVar) {
        this.bgz = frsActivity;
        this.bgD = ahVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        String str;
        boolean z;
        cVar.dismiss();
        switch (i) {
            case 0:
                str = this.bgz.mThreadId;
                if (str != null) {
                    FrsActivity frsActivity = this.bgz;
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(this.bgz.getPageContext().getPageActivity());
                    com.baidu.tbadk.core.data.ah ahVar = this.bgD;
                    String str2 = this.bgz.bfv;
                    z = this.bgz.bfB;
                    frsActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createFromThreadCfg(ahVar, str2, null, 18003, true, false, z)));
                    break;
                }
                break;
            case 1:
                this.bgz.d(this.bgD);
                break;
            case 2:
                this.bgz.e(this.bgD);
                break;
        }
        com.baidu.tieba.tbadkCore.util.r readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
        if (readThreadHistory != null && this.bgD != null && !readThreadHistory.mU(this.bgD.getId())) {
            readThreadHistory.mT(this.bgD.getId());
        }
        this.bgz.bfD.PW();
    }
}
