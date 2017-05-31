package com.baidu.tieba.homepage.personalize;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.ae;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements ae.a {
    final /* synthetic */ b cAU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(b bVar) {
        this.cAU = bVar;
    }

    @Override // com.baidu.tbadk.core.view.ae.a
    public void b(View view, boolean z) {
        o oVar;
        com.baidu.tieba.homepage.framework.b bVar;
        boolean z2;
        com.baidu.tieba.homepage.framework.b bVar2;
        List<com.baidu.tieba.homepage.b.a.a> list;
        boolean z3;
        o oVar2;
        o oVar3;
        oVar = this.cAU.cAM;
        if (oVar != null) {
            oVar2 = this.cAU.cAM;
            oVar2.fc(true);
            oVar3 = this.cAU.cAM;
            oVar3.aiP();
        }
        bVar = this.cAU.cAL;
        if (bVar != null) {
            z2 = this.cAU.cAP;
            if (z2) {
                bVar2 = this.cAU.cAL;
                list = this.cAU.cAn;
                z3 = this.cAU.cAQ;
                bVar2.i(list, z3);
            }
        }
        this.cAU.cAP = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
    }
}
