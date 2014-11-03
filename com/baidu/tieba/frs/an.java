package com.baidu.tieba.frs;

import android.content.DialogInterface;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements DialogInterface.OnClickListener {
    final /* synthetic */ FrsActivity aBu;
    private final /* synthetic */ com.baidu.tbadk.core.data.q aBx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(FrsActivity frsActivity, com.baidu.tbadk.core.data.q qVar) {
        this.aBu = frsActivity;
        this.aBx = qVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        String str;
        String str2;
        boolean z;
        bu buVar;
        switch (i) {
            case 0:
                str = this.aBu.mThreadId;
                if (str != null) {
                    FrsActivity frsActivity = this.aBu;
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(this.aBu);
                    com.baidu.tbadk.core.data.q qVar = this.aBx;
                    str2 = this.aBu.aAx;
                    z = this.aBu.aAE;
                    frsActivity.sendMessage(new CustomMessage(2004001, pbActivityConfig.createFromThreadCfg(qVar, str2, null, 18003, true, false, z)));
                    break;
                }
                break;
            case 1:
                this.aBu.e(this.aBx);
                break;
            case 2:
                this.aBu.f(this.aBx);
                break;
        }
        com.baidu.tieba.util.o wL = com.baidu.tieba.aj.wm().wL();
        if (wL != null && this.aBx != null && !wL.hH(this.aBx.getId())) {
            wL.hG(this.aBx.getId());
        }
        buVar = this.aBu.aAF;
        buVar.Gr();
    }
}
