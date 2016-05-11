package com.baidu.tieba.adkiller;

import com.baidu.adp.framework.MessageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    private final /* synthetic */ String aLQ;
    final /* synthetic */ d aLR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, String str) {
        this.aLR = dVar;
        this.aLQ = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        SubmitCloseNetMessage submitCloseNetMessage = new SubmitCloseNetMessage();
        submitCloseNetMessage.setKillTag(this.aLQ);
        submitCloseNetMessage.setType(1);
        MessageManager.getInstance().sendMessage(submitCloseNetMessage);
    }
}
