package com.baidu.tieba.frs;

import android.content.DialogInterface;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements DialogInterface.OnClickListener {
    final /* synthetic */ FrsActivity aDW;
    private final /* synthetic */ com.baidu.tbadk.core.data.x aEb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(FrsActivity frsActivity, com.baidu.tbadk.core.data.x xVar) {
        this.aDW = frsActivity;
        this.aEb = xVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        String str;
        String str2;
        boolean z;
        bp bpVar;
        switch (i) {
            case 0:
                str = this.aDW.mThreadId;
                if (str != null) {
                    FrsActivity frsActivity = this.aDW;
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(this.aDW.getPageContext().getPageActivity());
                    com.baidu.tbadk.core.data.x xVar = this.aEb;
                    str2 = this.aDW.aCQ;
                    z = this.aDW.aCX;
                    frsActivity.sendMessage(new CustomMessage(2004001, pbActivityConfig.createFromThreadCfg(xVar, str2, null, 18003, true, false, z)));
                    break;
                }
                break;
            case 1:
                this.aDW.b(this.aEb);
                break;
            case 2:
                this.aDW.c(this.aEb);
                break;
        }
        com.baidu.tieba.tbadkCore.util.l readThreadHistory = TbadkCoreApplication.m255getInst().getReadThreadHistory();
        if (readThreadHistory != null && this.aEb != null && !readThreadHistory.iw(this.aEb.getId())) {
            readThreadHistory.iv(this.aEb.getId());
        }
        bpVar = this.aDW.aCY;
        bpVar.GT();
    }
}
