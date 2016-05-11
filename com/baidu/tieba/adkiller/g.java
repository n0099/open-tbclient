package com.baidu.tieba.adkiller;

import com.baidu.adp.framework.MessageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    private final /* synthetic */ String aLS;
    final /* synthetic */ f aLT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar, String str) {
        this.aLT = fVar;
        this.aLS = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        SubmitCloseNetMessage submitCloseNetMessage = new SubmitCloseNetMessage();
        submitCloseNetMessage.setKillTag(this.aLS);
        submitCloseNetMessage.setType(2);
        MessageManager.getInstance().sendMessage(submitCloseNetMessage);
    }
}
