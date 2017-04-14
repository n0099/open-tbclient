package com.baidu.tieba.frs.entelechy.view;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class ar implements Runnable {
    final /* synthetic */ am bTG;
    private final /* synthetic */ String btG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(am amVar, String str) {
        this.bTG = amVar;
        this.btG = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR, this.btG));
    }
}
