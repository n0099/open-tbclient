package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements c.b {
    final /* synthetic */ FrsActivity bhl;
    private final /* synthetic */ com.baidu.tbadk.core.data.ax bhs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(FrsActivity frsActivity, com.baidu.tbadk.core.data.ax axVar) {
        this.bhl = frsActivity;
        this.bhs = axVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        String str;
        boolean z;
        cn cnVar;
        cVar.dismiss();
        switch (i) {
            case 0:
                str = this.bhl.mThreadId;
                if (str != null) {
                    FrsActivity frsActivity = this.bhl;
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(this.bhl.getPageContext().getPageActivity());
                    com.baidu.tbadk.core.data.ax axVar = this.bhs;
                    String str2 = this.bhl.bgf;
                    z = this.bhl.bgm;
                    frsActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createFromThreadCfg(axVar, str2, null, 18003, true, false, z)));
                    break;
                }
                break;
            case 1:
                this.bhl.d(this.bhs);
                break;
            case 2:
                this.bhl.e(this.bhs);
                break;
        }
        com.baidu.tieba.tbadkCore.util.s readThreadHistory = TbadkCoreApplication.m11getInst().getReadThreadHistory();
        if (readThreadHistory != null && this.bhs != null && !readThreadHistory.od(this.bhs.getId())) {
            readThreadHistory.oc(this.bhs.getId());
        }
        cnVar = this.bhl.bgo;
        cnVar.QO();
    }
}
