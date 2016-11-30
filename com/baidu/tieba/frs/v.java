package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements c.b {
    final /* synthetic */ FrsActivity bTa;
    private final /* synthetic */ com.baidu.tbadk.core.data.bk bTd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(FrsActivity frsActivity, com.baidu.tbadk.core.data.bk bkVar) {
        this.bTa = frsActivity;
        this.bTd = bkVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        String str;
        boolean z;
        String str2;
        boolean z2;
        String str3;
        boolean z3;
        cVar.dismiss();
        switch (i) {
            case 0:
                str3 = this.bTa.mThreadId;
                if (str3 != null) {
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(this.bTa.getPageContext().getPageActivity());
                    com.baidu.tbadk.core.data.bk bkVar = this.bTd;
                    String str4 = this.bTa.bRN;
                    z3 = this.bTa.bRU;
                    PbActivityConfig createFromThreadCfg = pbActivityConfig.createFromThreadCfg(bkVar, str4, null, 18003, true, false, z3);
                    createFromThreadCfg.setVideo_source("frs");
                    this.bTa.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                    break;
                }
                break;
            case 1:
                FrsActivity frsActivity = this.bTa;
                str2 = this.bTa.mThreadId;
                com.baidu.tbadk.core.data.bk bkVar2 = this.bTd;
                z2 = this.bTa.bRU;
                com.baidu.tieba.frs.utils.u.a(frsActivity, str2, bkVar2, z2);
                break;
            case 2:
                FrsActivity frsActivity2 = this.bTa;
                str = this.bTa.mThreadId;
                com.baidu.tbadk.core.data.bk bkVar3 = this.bTd;
                z = this.bTa.bRU;
                com.baidu.tieba.frs.utils.u.b(frsActivity2, str, bkVar3, z);
                break;
        }
        com.baidu.tieba.tbadkCore.util.r readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
        if (readThreadHistory != null && this.bTd != null && !readThreadHistory.rP(this.bTd.getId())) {
            readThreadHistory.rO(this.bTd.getId());
        }
        this.bTa.bRW.acT();
    }
}
