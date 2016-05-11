package com.baidu.tieba.frs.entelechy.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class aj implements Runnable {
    private final /* synthetic */ String aQH;
    final /* synthetic */ af bpP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(af afVar, String str) {
        this.bpP = afVar;
        this.aQH = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR, this.aQH));
    }
}
