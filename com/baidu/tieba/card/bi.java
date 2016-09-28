package com.baidu.tieba.card;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class bi implements Runnable {
    final /* synthetic */ be baC;
    private final /* synthetic */ String baD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(be beVar, String str) {
        this.baC = beVar;
        this.baD = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR, this.baD));
    }
}
