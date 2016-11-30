package com.baidu.tieba.homepage.personalize;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.z;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements z.a {
    final /* synthetic */ a cKG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(a aVar) {
        this.cKG = aVar;
    }

    @Override // com.baidu.tbadk.core.view.z.a
    public void F(View view) {
        n nVar;
        n nVar2;
        n nVar3;
        nVar = this.cKG.cKz;
        if (nVar != null) {
            nVar2 = this.cKG.cKz;
            nVar2.fr(true);
            nVar3 = this.cKG.cKz;
            nVar3.aoz();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
    }
}
