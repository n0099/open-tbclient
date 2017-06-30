package com.baidu.tieba.homepage.personalize;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.ae;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements ae.a {
    final /* synthetic */ i cIQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar) {
        this.cIQ = iVar;
    }

    @Override // com.baidu.tbadk.core.view.ae.a
    public void b(View view, boolean z) {
        x xVar;
        com.baidu.tieba.homepage.framework.b bVar;
        boolean z2;
        com.baidu.tieba.homepage.framework.b bVar2;
        List<com.baidu.tieba.homepage.b.a.a> list;
        boolean z3;
        x xVar2;
        x xVar3;
        xVar = this.cIQ.cIH;
        if (xVar != null) {
            xVar2 = this.cIQ.cIH;
            xVar2.ft(true);
            xVar3 = this.cIQ.cIH;
            xVar3.amB();
        }
        bVar = this.cIQ.cIG;
        if (bVar != null) {
            z2 = this.cIQ.cIK;
            if (z2) {
                bVar2 = this.cIQ.cIG;
                list = this.cIQ.cHZ;
                z3 = this.cIQ.cIL;
                bVar2.j(list, z3);
            }
        }
        this.cIQ.cIK = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
    }
}
