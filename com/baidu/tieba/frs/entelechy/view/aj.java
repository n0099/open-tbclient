package com.baidu.tieba.frs.entelechy.view;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class aj implements Runnable {
    private final /* synthetic */ String aKw;
    final /* synthetic */ ae bMe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ae aeVar, String str) {
        this.bMe = aeVar;
        this.aKw = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR, this.aKw));
    }
}
