package com.baidu.tieba.card;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class bi implements Runnable {
    final /* synthetic */ be bdL;
    private final /* synthetic */ String bdM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(be beVar, String str) {
        this.bdL = beVar;
        this.bdM = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR, this.bdM));
    }
}
