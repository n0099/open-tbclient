package com.baidu.tieba.adkiller;

import com.baidu.adp.framework.MessageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    private final /* synthetic */ String aML;
    final /* synthetic */ d aMM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, String str) {
        this.aMM = dVar;
        this.aML = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        SubmitCloseNetMessage submitCloseNetMessage = new SubmitCloseNetMessage();
        submitCloseNetMessage.setKillTag(this.aML);
        submitCloseNetMessage.setType(1);
        MessageManager.getInstance().sendMessage(submitCloseNetMessage);
    }
}
