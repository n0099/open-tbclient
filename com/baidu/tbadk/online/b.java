package com.baidu.tbadk.online;

import com.baidu.adp.framework.MessageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a afE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.afE = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        MessageManager.getInstance().sendMessage(new GeOnLineInfoReqMessage());
    }
}
