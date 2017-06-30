package com.baidu.tieba.frs.f;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.ae;
import com.baidu.tieba.frs.av;
import com.baidu.tieba.frs.cc;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements ae.a {
    final /* synthetic */ x cqf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(x xVar) {
        this.cqf = xVar;
    }

    @Override // com.baidu.tbadk.core.view.ae.a
    public void b(View view, boolean z) {
        com.baidu.tieba.frs.smartsort.c cVar;
        av avVar;
        cc ccVar;
        m mVar;
        com.baidu.tieba.frs.smartsort.c cVar2;
        com.baidu.tieba.frs.r rVar;
        com.baidu.tieba.frs.r rVar2;
        com.baidu.tieba.frs.r rVar3;
        com.baidu.tieba.frs.r rVar4;
        com.baidu.tieba.frs.smartsort.c cVar3;
        cVar = this.cqf.ccx;
        if (cVar != null) {
            rVar2 = this.cqf.cbE;
            if (rVar2.adU() != null) {
                rVar3 = this.cqf.cbE;
                if (rVar3.adU().aeu() != null) {
                    rVar4 = this.cqf.cbE;
                    if (!rVar4.adU().aeu().afO()) {
                        cVar3 = this.cqf.ccx;
                        cVar3.ahi();
                    }
                }
            }
        }
        avVar = this.cqf.ccj;
        if (avVar != null) {
            ccVar = this.cqf.cne;
            if (ccVar != null) {
                mVar = this.cqf.cct;
                if (mVar != null) {
                    cVar2 = this.cqf.ccx;
                    if (cVar2 != null) {
                        rVar = this.cqf.cbE;
                        rVar.et(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
                    }
                }
            }
        }
    }
}
