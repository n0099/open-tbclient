package com.baidu.tieba.card;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class bk implements Runnable {
    final /* synthetic */ bg bak;
    private final /* synthetic */ String bal;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(bg bgVar, String str) {
        this.bak = bgVar;
        this.bal = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR, this.bal));
    }
}
