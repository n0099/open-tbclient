package com.baidu.tieba.card;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class bq implements Runnable {
    final /* synthetic */ bj bCC;
    private final /* synthetic */ String bCD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(bj bjVar, String str) {
        this.bCC = bjVar;
        this.bCD = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR, this.bCD));
    }
}
