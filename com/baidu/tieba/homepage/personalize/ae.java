package com.baidu.tieba.homepage.personalize;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements t.c {
    final /* synthetic */ z cFs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(z zVar) {
        this.cFs = zVar;
    }

    @Override // com.baidu.tbadk.core.view.t.c
    public void aJ(boolean z) {
        b bVar;
        b bVar2;
        b bVar3;
        b bVar4;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_TO_REFRESH, Boolean.valueOf(z)));
        bVar = this.cFs.cFn;
        if (bVar != null) {
            bVar2 = this.cFs.cFn;
            if (bVar2.Ki() != null) {
                bVar4 = this.cFs.cFn;
                bVar4.Ki().aZR();
            }
            bVar3 = this.cFs.cFn;
            bVar3.fb(false);
        }
    }
}
