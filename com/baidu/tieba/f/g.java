package com.baidu.tieba.f;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.newFriends.RequestUnreadPointNum;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ a fmo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(a aVar) {
        this.fmo = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        z = this.fmo.fmh;
        if (!z) {
            MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
        }
    }
}
