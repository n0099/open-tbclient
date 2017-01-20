package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements c.b {
    final /* synthetic */ FrsActivity bGL;
    private final /* synthetic */ com.baidu.tbadk.core.data.bh bGO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(FrsActivity frsActivity, com.baidu.tbadk.core.data.bh bhVar) {
        this.bGL = frsActivity;
        this.bGO = bhVar;
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
                str3 = this.bGL.mThreadId;
                if (str3 != null) {
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(this.bGL.getPageContext().getPageActivity());
                    com.baidu.tbadk.core.data.bh bhVar = this.bGO;
                    String str4 = this.bGL.bFw;
                    z3 = this.bGL.bFD;
                    PbActivityConfig createFromThreadCfg = pbActivityConfig.createFromThreadCfg(bhVar, str4, null, 18003, true, false, z3);
                    createFromThreadCfg.setVideo_source("frs");
                    this.bGL.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                    break;
                }
                break;
            case 1:
                FrsActivity frsActivity = this.bGL;
                str2 = this.bGL.mThreadId;
                com.baidu.tbadk.core.data.bh bhVar2 = this.bGO;
                z2 = this.bGL.bFD;
                com.baidu.tieba.frs.utils.t.a(frsActivity, str2, bhVar2, z2);
                break;
            case 2:
                FrsActivity frsActivity2 = this.bGL;
                str = this.bGL.mThreadId;
                com.baidu.tbadk.core.data.bh bhVar3 = this.bGO;
                z = this.bGL.bFD;
                com.baidu.tieba.frs.utils.t.b(frsActivity2, str, bhVar3, z);
                break;
        }
        com.baidu.tieba.tbadkCore.util.r readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
        if (readThreadHistory != null && this.bGO != null && !readThreadHistory.qP(this.bGO.getId())) {
            readThreadHistory.qO(this.bGO.getId());
        }
        this.bGL.bFF.Yy();
    }
}
