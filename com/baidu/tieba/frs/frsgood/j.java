package com.baidu.tieba.frs.frsgood;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements c.b {
    private final /* synthetic */ com.baidu.tbadk.core.data.ah bgD;
    final /* synthetic */ FrsGoodActivity bnm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(FrsGoodActivity frsGoodActivity, com.baidu.tbadk.core.data.ah ahVar) {
        this.bnm = frsGoodActivity;
        this.bgD = ahVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        String str;
        String str2;
        boolean z;
        cVar.dismiss();
        switch (i) {
            case 0:
                str = this.bnm.mThreadId;
                if (str != null) {
                    FrsGoodActivity frsGoodActivity = this.bnm;
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(this.bnm.getPageContext().getPageActivity());
                    com.baidu.tbadk.core.data.ah ahVar = this.bgD;
                    str2 = this.bnm.bfv;
                    z = this.bnm.bfB;
                    frsGoodActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createFromThreadCfg(ahVar, str2, null, 18003, true, false, z)));
                    break;
                }
                break;
            case 1:
                this.bnm.d(this.bgD);
                break;
            case 2:
                this.bnm.e(this.bgD);
                break;
        }
        com.baidu.tieba.tbadkCore.util.r readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
        if (readThreadHistory != null && this.bgD != null && !readThreadHistory.mU(this.bgD.getId())) {
            readThreadHistory.mT(this.bgD.getId());
        }
        this.bnm.bng.PW();
    }
}
