package com.baidu.tieba.homepage.personalize;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements t.a {
    final /* synthetic */ z cFs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(z zVar) {
        this.cFs = zVar;
    }

    @Override // com.baidu.tbadk.core.view.t.a
    public void F(View view) {
        b bVar;
        b bVar2;
        b bVar3;
        bVar = this.cFs.cFn;
        if (bVar != null) {
            bVar2 = this.cFs.cFn;
            bVar2.fb(true);
            bVar3 = this.cFs.cFn;
            bVar3.amm();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
    }
}
