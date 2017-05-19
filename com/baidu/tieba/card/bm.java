package com.baidu.tieba.card;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class bm implements Runnable {
    final /* synthetic */ bf bvZ;
    private final /* synthetic */ String bwa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(bf bfVar, String str) {
        this.bvZ = bfVar;
        this.bwa = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR, this.bwa));
    }
}
