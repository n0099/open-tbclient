package com.baidu.tieba.frs.collect;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.z;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.util.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements c.b {
    private final /* synthetic */ z bak;
    final /* synthetic */ MyCollectFrsActivity bgk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(MyCollectFrsActivity myCollectFrsActivity, z zVar) {
        this.bgk = myCollectFrsActivity;
        this.bak = zVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        String str;
        String str2;
        boolean z;
        l lVar;
        cVar.dismiss();
        switch (i) {
            case 0:
                str = this.bgk.bgd;
                if (str != null) {
                    MyCollectFrsActivity myCollectFrsActivity = this.bgk;
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(this.bgk.getPageContext().getPageActivity());
                    z zVar = this.bak;
                    str2 = this.bgk.mForumName;
                    z = this.bgk.bgj;
                    myCollectFrsActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createFromThreadCfg(zVar, str2, null, 18003, true, false, z)));
                    break;
                }
                break;
            case 1:
                this.bgk.b(this.bak);
                break;
            case 2:
                this.bgk.c(this.bak);
                break;
        }
        p readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
        if (readThreadHistory != null && this.bak != null && !readThreadHistory.mF(this.bak.getId())) {
            readThreadHistory.mE(this.bak.getId());
        }
        lVar = this.bgk.bgf;
        lVar.ND();
    }
}
