package com.baidu.tieba.frs.f;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.ab;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.ax;
import com.baidu.tieba.frs.ce;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements ab.a {
    final /* synthetic */ ah cdq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(ah ahVar) {
        this.cdq = ahVar;
    }

    @Override // com.baidu.tbadk.core.view.ab.a
    public void B(View view) {
        ax axVar;
        ce ceVar;
        u uVar;
        com.baidu.tieba.frs.smartsort.c cVar;
        u uVar2;
        FrsActivity frsActivity;
        com.baidu.tieba.frs.smartsort.c cVar2;
        u uVar3;
        u uVar4;
        u uVar5;
        axVar = this.cdq.bMN;
        if (axVar != null) {
            ceVar = this.cdq.bZT;
            if (ceVar != null) {
                uVar = this.cdq.bMZ;
                if (uVar != null) {
                    cVar = this.cdq.bNg;
                    if (cVar != null) {
                        uVar2 = this.cdq.bMZ;
                        if (uVar2 != null) {
                            uVar3 = this.cdq.bMZ;
                            if (uVar3.adU() != null) {
                                uVar4 = this.cdq.bMZ;
                                if (uVar4.adU().aeB() != null) {
                                    uVar5 = this.cdq.bMZ;
                                    uVar5.adU().aeB().setDoingPullRefresh(false);
                                }
                            }
                        }
                        frsActivity = this.cdq.bTf;
                        frsActivity.dA(true);
                        cVar2 = this.cdq.bNg;
                        cVar2.ado();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
                    }
                }
            }
        }
    }
}
