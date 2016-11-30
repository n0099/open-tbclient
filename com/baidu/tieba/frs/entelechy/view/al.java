package com.baidu.tieba.frs.entelechy.view;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class al implements Runnable {
    private final /* synthetic */ String bdM;
    final /* synthetic */ ag caH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ag agVar, String str) {
        this.caH = agVar;
        this.bdM = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR, this.bdM));
    }
}
