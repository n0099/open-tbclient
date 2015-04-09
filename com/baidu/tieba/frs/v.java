package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements com.baidu.tbadk.core.dialog.h {
    final /* synthetic */ FrsActivity aJQ;
    private final /* synthetic */ com.baidu.tbadk.core.data.w aJW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(FrsActivity frsActivity, com.baidu.tbadk.core.data.w wVar) {
        this.aJQ = frsActivity;
        this.aJW = wVar;
    }

    @Override // com.baidu.tbadk.core.dialog.h
    public void itemClick(com.baidu.tbadk.core.dialog.e eVar, int i, View view) {
        String str;
        String str2;
        boolean z;
        bf bfVar;
        eVar.dismiss();
        switch (i) {
            case 0:
                str = this.aJQ.mThreadId;
                if (str != null) {
                    FrsActivity frsActivity = this.aJQ;
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(this.aJQ.getPageContext().getPageActivity());
                    com.baidu.tbadk.core.data.w wVar = this.aJW;
                    str2 = this.aJQ.aIS;
                    z = this.aJQ.aIY;
                    frsActivity.sendMessage(new CustomMessage(2004001, pbActivityConfig.createFromThreadCfg(wVar, str2, null, 18003, true, false, z)));
                    break;
                }
                break;
            case 1:
                this.aJQ.b(this.aJW);
                break;
            case 2:
                this.aJQ.c(this.aJW);
                break;
        }
        com.baidu.tieba.tbadkCore.util.l readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
        if (readThreadHistory != null && this.aJW != null && !readThreadHistory.iR(this.aJW.getId())) {
            readThreadHistory.iQ(this.aJW.getId());
        }
        bfVar = this.aJQ.aJa;
        bfVar.Ki();
    }
}
