package com.baidu.tieba.enterForum.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.ab;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements ab.c {
    final /* synthetic */ e bFP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.bFP = eVar;
    }

    @Override // com.baidu.tbadk.core.view.ab.c
    public void aO(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_TO_REFRESH, Boolean.valueOf(z)));
    }
}
