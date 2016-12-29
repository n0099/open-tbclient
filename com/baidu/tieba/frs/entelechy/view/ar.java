package com.baidu.tieba.frs.entelechy.view;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class ar implements Runnable {
    final /* synthetic */ am bGv;
    private final /* synthetic */ String bde;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(am amVar, String str) {
        this.bGv = amVar;
        this.bde = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR, this.bde));
    }
}
