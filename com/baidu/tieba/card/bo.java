package com.baidu.tieba.card;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class bo implements Runnable {
    final /* synthetic */ bk btF;
    private final /* synthetic */ String btG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(bk bkVar, String str) {
        this.btF = bkVar;
        this.btG = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR, this.btG));
    }
}
