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
    final /* synthetic */ FrsActivity bed;
    private final /* synthetic */ com.baidu.tbadk.core.data.z beh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(FrsActivity frsActivity, com.baidu.tbadk.core.data.z zVar) {
        this.bed = frsActivity;
        this.beh = zVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        String str;
        boolean z;
        cVar.dismiss();
        switch (i) {
            case 0:
                str = this.bed.mThreadId;
                if (str != null) {
                    FrsActivity frsActivity = this.bed;
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(this.bed.getPageContext().getPageActivity());
                    com.baidu.tbadk.core.data.z zVar = this.beh;
                    String str2 = this.bed.bde;
                    z = this.bed.bdk;
                    frsActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createFromThreadCfg(zVar, str2, null, 18003, true, false, z)));
                    break;
                }
                break;
            case 1:
                this.bed.d(this.beh);
                break;
            case 2:
                this.bed.e(this.beh);
                break;
        }
        com.baidu.tieba.tbadkCore.util.q readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
        if (readThreadHistory != null && this.beh != null && !readThreadHistory.mC(this.beh.getId())) {
            readThreadHistory.mB(this.beh.getId());
        }
        this.bed.bdm.NW();
    }
}
