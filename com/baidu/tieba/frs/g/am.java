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
    final /* synthetic */ ah cei;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(ah ahVar) {
        this.cei = ahVar;
    }

    @Override // com.baidu.tbadk.core.view.ab.a
    public void B(View view) {
        az azVar;
        cg cgVar;
        u uVar;
        com.baidu.tieba.frs.smartsort.c cVar;
        FrsActivity frsActivity;
        com.baidu.tieba.frs.smartsort.c cVar2;
        azVar = this.cei.bOU;
        if (azVar != null) {
            cgVar = this.cei.caL;
            if (cgVar != null) {
                uVar = this.cei.bPg;
                if (uVar != null) {
                    cVar = this.cei.bPn;
                    if (cVar != null) {
                        frsActivity = this.cei.bVk;
                        frsActivity.dM(true);
                        cVar2 = this.cei.bPn;
                        cVar2.aej();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
                    }
                }
            }
        }
    }
}
