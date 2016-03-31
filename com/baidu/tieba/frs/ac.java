package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements c.b {
    final /* synthetic */ FrsActivity blk;
    private final /* synthetic */ com.baidu.tbadk.core.data.as blo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(FrsActivity frsActivity, com.baidu.tbadk.core.data.as asVar) {
        this.blk = frsActivity;
        this.blo = asVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        String str;
        boolean z;
        cVar.dismiss();
        switch (i) {
            case 0:
                str = this.blk.mThreadId;
                if (str != null) {
                    FrsActivity frsActivity = this.blk;
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(this.blk.getPageContext().getPageActivity());
                    com.baidu.tbadk.core.data.as asVar = this.blo;
                    String str2 = this.blk.bkf;
                    z = this.blk.bkm;
                    frsActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createFromThreadCfg(asVar, str2, null, 18003, true, false, z)));
                    break;
                }
                break;
            case 1:
                this.blk.d(this.blo);
                break;
            case 2:
                this.blk.e(this.blo);
                break;
        }
        com.baidu.tieba.tbadkCore.util.s readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
        if (readThreadHistory != null && this.blo != null && !readThreadHistory.oh(this.blo.getId())) {
            readThreadHistory.og(this.blo.getId());
        }
        this.blk.bko.RP();
    }
}
