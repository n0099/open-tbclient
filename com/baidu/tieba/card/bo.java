package com.baidu.tieba.card;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class bo implements Runnable {
    private final /* synthetic */ String aKw;
    final /* synthetic */ bk aUZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(bk bkVar, String str) {
        this.aUZ = bkVar;
        this.aKw = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR, this.aKw));
    }
}
