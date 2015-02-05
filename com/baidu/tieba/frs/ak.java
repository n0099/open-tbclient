package com.baidu.tieba.frs;

import android.content.DialogInterface;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements DialogInterface.OnClickListener {
    final /* synthetic */ FrsActivity aDT;
    private final /* synthetic */ com.baidu.tbadk.core.data.x aDY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(FrsActivity frsActivity, com.baidu.tbadk.core.data.x xVar) {
        this.aDT = frsActivity;
        this.aDY = xVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        String str;
        String str2;
        boolean z;
        bp bpVar;
        switch (i) {
            case 0:
                str = this.aDT.mThreadId;
                if (str != null) {
                    FrsActivity frsActivity = this.aDT;
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(this.aDT.getPageContext().getPageActivity());
                    com.baidu.tbadk.core.data.x xVar = this.aDY;
                    str2 = this.aDT.aCN;
                    z = this.aDT.aCU;
                    frsActivity.sendMessage(new CustomMessage(2004001, pbActivityConfig.createFromThreadCfg(xVar, str2, null, 18003, true, false, z)));
                    break;
                }
                break;
            case 1:
                this.aDT.b(this.aDY);
                break;
            case 2:
                this.aDT.c(this.aDY);
                break;
        }
        com.baidu.tieba.tbadkCore.util.l readThreadHistory = TbadkCoreApplication.m255getInst().getReadThreadHistory();
        if (readThreadHistory != null && this.aDY != null && !readThreadHistory.iu(this.aDY.getId())) {
            readThreadHistory.it(this.aDY.getId());
        }
        bpVar = this.aDT.aCV;
        bpVar.GN();
    }
}
