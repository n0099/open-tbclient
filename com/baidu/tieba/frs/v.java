package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements com.baidu.tbadk.core.dialog.h {
    final /* synthetic */ FrsActivity aLY;
    private final /* synthetic */ com.baidu.tbadk.core.data.w aMe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(FrsActivity frsActivity, com.baidu.tbadk.core.data.w wVar) {
        this.aLY = frsActivity;
        this.aMe = wVar;
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
                str = this.aLY.mThreadId;
                if (str != null) {
                    FrsActivity frsActivity = this.aLY;
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(this.aLY.getPageContext().getPageActivity());
                    com.baidu.tbadk.core.data.w wVar = this.aMe;
                    str2 = this.aLY.aLc;
                    z = this.aLY.aLh;
                    frsActivity.sendMessage(new CustomMessage(2004001, pbActivityConfig.createFromThreadCfg(wVar, str2, null, 18003, true, false, z)));
                    break;
                }
                break;
            case 1:
                this.aLY.b(this.aMe);
                break;
            case 2:
                this.aLY.c(this.aMe);
                break;
        }
        com.baidu.tieba.tbadkCore.util.l readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
        if (readThreadHistory != null && this.aMe != null && !readThreadHistory.jL(this.aMe.getId())) {
            readThreadHistory.jK(this.aMe.getId());
        }
        bfVar = this.aLY.aLj;
        bfVar.Lo();
    }
}
