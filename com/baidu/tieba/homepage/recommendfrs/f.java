package com.baidu.tieba.homepage.recommendfrs;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.ab;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements ab.c {
    final /* synthetic */ b cCi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(b bVar) {
        this.cCi = bVar;
    }

    @Override // com.baidu.tbadk.core.view.ab.c
    public void aO(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_TO_REFRESH, Boolean.valueOf(z)));
    }
}
