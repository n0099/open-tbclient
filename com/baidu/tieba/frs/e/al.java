package com.baidu.tieba.frs.e;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.ae;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.ca;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements ae.a {
    final /* synthetic */ ag cbR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ag agVar) {
        this.cbR = agVar;
    }

    @Override // com.baidu.tbadk.core.view.ae.a
    public void b(View view, boolean z) {
        com.baidu.tieba.frs.smartsort.c cVar;
        at atVar;
        ca caVar;
        u uVar;
        com.baidu.tieba.frs.smartsort.c cVar2;
        com.baidu.tieba.frs.r rVar;
        com.baidu.tieba.frs.smartsort.c cVar3;
        cVar = this.cbR.bOC;
        if (cVar != null) {
            cVar3 = this.cbR.bOC;
            cVar3.acm();
        }
        atVar = this.cbR.bOn;
        if (atVar != null) {
            caVar = this.cbR.bYD;
            if (caVar != null) {
                uVar = this.cbR.bOx;
                if (uVar != null) {
                    cVar2 = this.cbR.bOC;
                    if (cVar2 != null) {
                        rVar = this.cbR.bNK;
                        rVar.dL(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
                    }
                }
            }
        }
    }
}
