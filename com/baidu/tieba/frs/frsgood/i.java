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
    private final /* synthetic */ com.baidu.tbadk.core.data.z beh;
    final /* synthetic */ FrsGoodActivity bkp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(FrsGoodActivity frsGoodActivity, com.baidu.tbadk.core.data.z zVar) {
        this.bkp = frsGoodActivity;
        this.beh = zVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        String str;
        String str2;
        boolean z;
        cVar.dismiss();
        switch (i) {
            case 0:
                str = this.bkp.mThreadId;
                if (str != null) {
                    FrsGoodActivity frsGoodActivity = this.bkp;
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(this.bkp.getPageContext().getPageActivity());
                    com.baidu.tbadk.core.data.z zVar = this.beh;
                    str2 = this.bkp.bde;
                    z = this.bkp.bdk;
                    frsGoodActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createFromThreadCfg(zVar, str2, null, 18003, true, false, z)));
                    break;
                }
                break;
            case 1:
                this.bkp.d(this.beh);
                break;
            case 2:
                this.bkp.e(this.beh);
                break;
        }
        com.baidu.tieba.tbadkCore.util.q readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
        if (readThreadHistory != null && this.beh != null && !readThreadHistory.mD(this.beh.getId())) {
            readThreadHistory.mC(this.beh.getId());
        }
        this.bkp.bkj.NW();
    }
}
