package com.baidu.tieba.enterForum.e;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements t.c {
    final /* synthetic */ e bIg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.bIg = eVar;
    }

    @Override // com.baidu.tbadk.core.view.t.c
    public void aJ(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_TO_REFRESH, Boolean.valueOf(z)));
    }
}
