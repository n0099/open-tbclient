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
    final /* synthetic */ b cuC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(b bVar) {
        this.cuC = bVar;
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
        oVar = this.cuC.cuu;
        if (oVar != null) {
            oVar2 = this.cuC.cuu;
            oVar2.eM(true);
            oVar3 = this.cuC.cuu;
            oVar3.ahA();
        }
        bVar = this.cuC.cut;
        if (bVar != null) {
            z2 = this.cuC.cux;
            if (z2) {
                bVar2 = this.cuC.cut;
                list = this.cuC.ctV;
                z3 = this.cuC.cuy;
                bVar2.i(list, z3);
            }
        }
        this.cuC.cux = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
    }
}
