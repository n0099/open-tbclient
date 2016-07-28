package com.baidu.tieba.homepage.recommendfrs;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements t.d {
    final /* synthetic */ b cwb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(b bVar) {
        this.cwb = bVar;
    }

    @Override // com.baidu.tbadk.core.view.t.d
    public void aI(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_TO_REFRESH, Boolean.valueOf(z)));
    }
}
