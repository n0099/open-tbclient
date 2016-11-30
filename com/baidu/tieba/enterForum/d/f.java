package com.baidu.tieba.enterForum.d;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.z;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements z.c {
    final /* synthetic */ e bLb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.bLb = eVar;
    }

    @Override // com.baidu.tbadk.core.view.z.c
    public void aM(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_TO_REFRESH, Boolean.valueOf(z)));
    }
}
