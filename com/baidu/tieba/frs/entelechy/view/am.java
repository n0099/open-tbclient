package com.baidu.tieba.frs.entelechy.view;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class am implements Runnable {
    final /* synthetic */ ah bXw;
    private final /* synthetic */ String bal;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(ah ahVar, String str) {
        this.bXw = ahVar;
        this.bal = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR, this.bal));
    }
}
