package com.baidu.tieba.card;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class bk implements Runnable {
    final /* synthetic */ bg bdd;
    private final /* synthetic */ String bde;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(bg bgVar, String str) {
        this.bdd = bgVar;
        this.bde = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR, this.bde));
    }
}
