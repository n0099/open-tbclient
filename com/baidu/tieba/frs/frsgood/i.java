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
    private final /* synthetic */ com.baidu.tbadk.core.data.v aVq;
    final /* synthetic */ FrsGoodActivity aZp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(FrsGoodActivity frsGoodActivity, com.baidu.tbadk.core.data.v vVar) {
        this.aZp = frsGoodActivity;
        this.aVq = vVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        String str;
        String str2;
        boolean z;
        cVar.dismiss();
        switch (i) {
            case 0:
                str = this.aZp.mThreadId;
                if (str != null) {
                    FrsGoodActivity frsGoodActivity = this.aZp;
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(this.aZp.getPageContext().getPageActivity());
                    com.baidu.tbadk.core.data.v vVar = this.aVq;
                    str2 = this.aZp.aUq;
                    z = this.aZp.aUu;
                    frsGoodActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createFromThreadCfg(vVar, str2, null, 18003, true, false, z)));
                    break;
                }
                break;
            case 1:
                this.aZp.b(this.aVq);
                break;
            case 2:
                this.aZp.c(this.aVq);
                break;
        }
        com.baidu.tieba.tbadkCore.util.m readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
        if (readThreadHistory != null && this.aVq != null && !readThreadHistory.kE(this.aVq.getId())) {
            readThreadHistory.kD(this.aVq.getId());
        }
        this.aZp.aZj.Ma();
    }
}
