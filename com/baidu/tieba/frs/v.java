package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements com.baidu.tbadk.core.dialog.h {
    final /* synthetic */ FrsActivity aLX;
    private final /* synthetic */ com.baidu.tbadk.core.data.w aMd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(FrsActivity frsActivity, com.baidu.tbadk.core.data.w wVar) {
        this.aLX = frsActivity;
        this.aMd = wVar;
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
                str = this.aLX.mThreadId;
                if (str != null) {
                    FrsActivity frsActivity = this.aLX;
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(this.aLX.getPageContext().getPageActivity());
                    com.baidu.tbadk.core.data.w wVar = this.aMd;
                    str2 = this.aLX.aLb;
                    z = this.aLX.aLg;
                    frsActivity.sendMessage(new CustomMessage(2004001, pbActivityConfig.createFromThreadCfg(wVar, str2, null, 18003, true, false, z)));
                    break;
                }
                break;
            case 1:
                this.aLX.b(this.aMd);
                break;
            case 2:
                this.aLX.c(this.aMd);
                break;
        }
        com.baidu.tieba.tbadkCore.util.l readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
        if (readThreadHistory != null && this.aMd != null && !readThreadHistory.jL(this.aMd.getId())) {
            readThreadHistory.jK(this.aMd.getId());
        }
        bfVar = this.aLX.aLi;
        bfVar.Ln();
    }
}
