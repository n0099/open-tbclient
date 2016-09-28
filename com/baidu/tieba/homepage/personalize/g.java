package com.baidu.tieba.homepage.personalize;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements y.c {
    final /* synthetic */ a cFs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(a aVar) {
        this.cFs = aVar;
    }

    @Override // com.baidu.tbadk.core.view.y.c
    public void aJ(boolean z) {
        m mVar;
        m mVar2;
        m mVar3;
        m mVar4;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_TO_REFRESH, Boolean.valueOf(z)));
        mVar = this.cFs.cFm;
        if (mVar != null) {
            mVar2 = this.cFs.cFm;
            if (mVar2.JP() != null) {
                mVar4 = this.cFs.cFm;
                mVar4.JP().bap();
            }
            mVar3 = this.cFs.cFm;
            mVar3.fc(false);
        }
    }
}
