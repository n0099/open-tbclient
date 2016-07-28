package com.baidu.tieba.homepage.personalize;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements t.a {
    final /* synthetic */ z ctN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(z zVar) {
        this.ctN = zVar;
    }

    @Override // com.baidu.tbadk.core.view.t.a
    public void E(View view) {
        b bVar;
        b bVar2;
        b bVar3;
        bVar = this.ctN.ctI;
        if (bVar != null) {
            bVar2 = this.ctN.ctI;
            bVar2.eF(true);
            bVar3 = this.ctN.ctI;
            bVar3.ahx();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
    }
}
