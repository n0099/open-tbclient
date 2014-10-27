package com.baidu.tieba.frs;

import android.content.DialogInterface;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements DialogInterface.OnClickListener {
    final /* synthetic */ FrsActivity aBk;
    private final /* synthetic */ com.baidu.tbadk.core.data.q aBn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(FrsActivity frsActivity, com.baidu.tbadk.core.data.q qVar) {
        this.aBk = frsActivity;
        this.aBn = qVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        String str;
        String str2;
        boolean z;
        bu buVar;
        switch (i) {
            case 0:
                str = this.aBk.mThreadId;
                if (str != null) {
                    FrsActivity frsActivity = this.aBk;
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(this.aBk);
                    com.baidu.tbadk.core.data.q qVar = this.aBn;
                    str2 = this.aBk.aAn;
                    z = this.aBk.aAu;
                    frsActivity.sendMessage(new CustomMessage(2004001, pbActivityConfig.createFromThreadCfg(qVar, str2, null, 18003, true, false, z)));
                    break;
                }
                break;
            case 1:
                this.aBk.e(this.aBn);
                break;
            case 2:
                this.aBk.f(this.aBn);
                break;
        }
        com.baidu.tieba.util.o wJ = com.baidu.tieba.aj.wk().wJ();
        if (wJ != null && this.aBn != null && !wJ.hH(this.aBn.getId())) {
            wJ.hG(this.aBn.getId());
        }
        buVar = this.aBk.aAv;
        buVar.Gp();
    }
}
