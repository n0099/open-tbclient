package com.baidu.tieba.frs.entelechy.view;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class an implements Runnable {
    private final /* synthetic */ String bCD;
    final /* synthetic */ ai chP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(ai aiVar, String str) {
        this.chP = aiVar;
        this.bCD = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR, this.bCD));
    }
}
