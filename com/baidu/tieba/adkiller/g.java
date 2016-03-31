package com.baidu.tieba.adkiller;

import com.baidu.adp.framework.MessageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    private final /* synthetic */ String aPI;
    final /* synthetic */ f aPJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar, String str) {
        this.aPJ = fVar;
        this.aPI = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        SubmitCloseNetMessage submitCloseNetMessage = new SubmitCloseNetMessage();
        submitCloseNetMessage.setKillTag(this.aPI);
        submitCloseNetMessage.setType(2);
        MessageManager.getInstance().sendMessage(submitCloseNetMessage);
    }
}
