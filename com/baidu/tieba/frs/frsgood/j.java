package com.baidu.tieba.frs.frsgood;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements c.b {
    private final /* synthetic */ as blo;
    final /* synthetic */ FrsGoodActivity bsj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(FrsGoodActivity frsGoodActivity, as asVar) {
        this.bsj = frsGoodActivity;
        this.blo = asVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        String str;
        String str2;
        boolean z;
        cVar.dismiss();
        switch (i) {
            case 0:
                str = this.bsj.mThreadId;
                if (str != null) {
                    FrsGoodActivity frsGoodActivity = this.bsj;
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(this.bsj.getPageContext().getPageActivity());
                    as asVar = this.blo;
                    str2 = this.bsj.bkf;
                    z = this.bsj.bkm;
                    frsGoodActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createFromThreadCfg(asVar, str2, null, 18003, true, false, z)));
                    break;
                }
                break;
            case 1:
                this.bsj.d(this.blo);
                break;
            case 2:
                this.bsj.e(this.blo);
                break;
        }
        com.baidu.tieba.tbadkCore.util.s readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
        if (readThreadHistory != null && this.blo != null && !readThreadHistory.oh(this.blo.getId())) {
            readThreadHistory.og(this.blo.getId());
        }
        this.bsj.bsd.RP();
    }
}
