package com.baidu.tieba.frs.g;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.ab;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.az;
import com.baidu.tieba.frs.cg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements ab.a {
    final /* synthetic */ ah cbR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(ah ahVar) {
        this.cbR = ahVar;
    }

    @Override // com.baidu.tbadk.core.view.ab.a
    public void B(View view) {
        az azVar;
        cg cgVar;
        u uVar;
        com.baidu.tieba.frs.smartsort.c cVar;
        FrsActivity frsActivity;
        com.baidu.tieba.frs.smartsort.c cVar2;
        azVar = this.cbR.bMD;
        if (azVar != null) {
            cgVar = this.cbR.bYu;
            if (cgVar != null) {
                uVar = this.cbR.bMP;
                if (uVar != null) {
                    cVar = this.cbR.bMW;
                    if (cVar != null) {
                        frsActivity = this.cbR.bST;
                        frsActivity.dC(true);
                        cVar2 = this.cbR.bMW;
                        cVar2.adi();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
                    }
                }
            }
        }
    }
}
