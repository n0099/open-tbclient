package com.baidu.tieba.homepage.recommendfrs;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements t.d {
    final /* synthetic */ b ctm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.ctm = bVar;
    }

    @Override // com.baidu.tbadk.core.view.t.d
    public void aF(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_TO_REFRESH, Boolean.valueOf(z)));
    }
}
