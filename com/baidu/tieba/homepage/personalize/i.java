package com.baidu.tieba.homepage.personalize;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements y.a {
    final /* synthetic */ a cFs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(a aVar) {
        this.cFs = aVar;
    }

    @Override // com.baidu.tbadk.core.view.y.a
    public void F(View view) {
        m mVar;
        m mVar2;
        m mVar3;
        mVar = this.cFs.cFm;
        if (mVar != null) {
            mVar2 = this.cFs.cFm;
            mVar2.fc(true);
            mVar3 = this.cFs.cFm;
            mVar3.amE();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
    }
}
