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
    private final /* synthetic */ com.baidu.tbadk.core.data.v aVq;
    final /* synthetic */ FrsActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(FrsActivity frsActivity, com.baidu.tbadk.core.data.v vVar) {
        this.this$0 = frsActivity;
        this.aVq = vVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        String str;
        boolean z;
        bl blVar;
        cVar.dismiss();
        switch (i) {
            case 0:
                str = this.this$0.mThreadId;
                if (str != null) {
                    FrsActivity frsActivity = this.this$0;
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(this.this$0.getPageContext().getPageActivity());
                    com.baidu.tbadk.core.data.v vVar = this.aVq;
                    String str2 = this.this$0.aUq;
                    z = this.this$0.aUu;
                    frsActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createFromThreadCfg(vVar, str2, null, 18003, true, false, z)));
                    break;
                }
                break;
            case 1:
                this.this$0.b(this.aVq);
                break;
            case 2:
                this.this$0.c(this.aVq);
                break;
        }
        com.baidu.tieba.tbadkCore.util.m readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
        if (readThreadHistory != null && this.aVq != null && !readThreadHistory.kE(this.aVq.getId())) {
            readThreadHistory.kD(this.aVq.getId());
        }
        blVar = this.this$0.aUw;
        blVar.Ma();
    }
}
