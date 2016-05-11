package com.baidu.tieba.card;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class bp implements Runnable {
    final /* synthetic */ bl aQG;
    private final /* synthetic */ String aQH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(bl blVar, String str) {
        this.aQG = blVar;
        this.aQH = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR, this.aQH));
    }
}
