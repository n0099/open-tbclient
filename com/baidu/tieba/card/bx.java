package com.baidu.tieba.card;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bx implements Runnable {
    final /* synthetic */ bt aUm;
    private final /* synthetic */ String aUn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bx(bt btVar, String str) {
        this.aUm = btVar;
        this.aUn = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR, this.aUn));
    }
}
