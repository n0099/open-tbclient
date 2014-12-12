package com.baidu.tieba.frs;

import android.content.DialogInterface;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements DialogInterface.OnClickListener {
    final /* synthetic */ FrsActivity aCV;
    private final /* synthetic */ com.baidu.tbadk.core.data.w aDa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(FrsActivity frsActivity, com.baidu.tbadk.core.data.w wVar) {
        this.aCV = frsActivity;
        this.aDa = wVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        String str;
        String str2;
        boolean z;
        bq bqVar;
        switch (i) {
            case 0:
                str = this.aCV.mThreadId;
                if (str != null) {
                    FrsActivity frsActivity = this.aCV;
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(this.aCV.getPageContext().getPageActivity());
                    com.baidu.tbadk.core.data.w wVar = this.aDa;
                    str2 = this.aCV.aBP;
                    z = this.aCV.aBW;
                    frsActivity.sendMessage(new CustomMessage(2004001, pbActivityConfig.createFromThreadCfg(wVar, str2, null, 18003, true, false, z)));
                    break;
                }
                break;
            case 1:
                this.aCV.b(this.aDa);
                break;
            case 2:
                this.aCV.c(this.aDa);
                break;
        }
        com.baidu.tieba.tbadkCore.util.l readThreadHistory = TbadkCoreApplication.m255getInst().getReadThreadHistory();
        if (readThreadHistory != null && this.aDa != null && !readThreadHistory.ip(this.aDa.getId())) {
            readThreadHistory.io(this.aDa.getId());
        }
        bqVar = this.aCV.aBX;
        bqVar.Gw();
    }
}
