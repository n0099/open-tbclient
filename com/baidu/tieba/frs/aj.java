package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements c.b {
    final /* synthetic */ FrsActivity bQp;
    private final /* synthetic */ com.baidu.tbadk.core.data.bg bQy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(FrsActivity frsActivity, com.baidu.tbadk.core.data.bg bgVar) {
        this.bQp = frsActivity;
        this.bQy = bgVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        String str;
        boolean z;
        bm bmVar;
        cVar.dismiss();
        switch (i) {
            case 0:
                str = this.bQp.mThreadId;
                if (str != null) {
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(this.bQp.getPageContext().getPageActivity());
                    com.baidu.tbadk.core.data.bg bgVar = this.bQy;
                    String str2 = this.bQp.bPf;
                    z = this.bQp.bPm;
                    PbActivityConfig createFromThreadCfg = pbActivityConfig.createFromThreadCfg(bgVar, str2, null, 18003, true, false, z);
                    createFromThreadCfg.setVideo_source("frs");
                    this.bQp.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                    break;
                }
                break;
            case 1:
                this.bQp.e(this.bQy);
                break;
            case 2:
                this.bQp.f(this.bQy);
                break;
        }
        com.baidu.tieba.tbadkCore.util.s readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
        if (readThreadHistory != null && this.bQy != null && !readThreadHistory.rf(this.bQy.getId())) {
            readThreadHistory.re(this.bQy.getId());
        }
        bmVar = this.bQp.bPo;
        bmVar.aby();
    }
}
