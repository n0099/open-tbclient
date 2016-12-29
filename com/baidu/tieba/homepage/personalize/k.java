package com.baidu.tieba.homepage.personalize;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.z;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements z.a {
    final /* synthetic */ a cqb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(a aVar) {
        this.cqb = aVar;
    }

    @Override // com.baidu.tbadk.core.view.z.a
    public void F(View view) {
        n nVar;
        n nVar2;
        n nVar3;
        nVar = this.cqb.cpU;
        if (nVar != null) {
            nVar2 = this.cqb.cpU;
            nVar2.fc(true);
            nVar3 = this.cqb.cpU;
            nVar3.aiZ();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
    }
}
