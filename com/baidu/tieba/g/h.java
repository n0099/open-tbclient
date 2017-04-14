package com.baidu.tieba.g;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.newFriends.RequestUnreadPointNum;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Runnable {
    final /* synthetic */ a ffB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.ffB = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        z = this.ffB.fft;
        if (!z) {
            MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
        }
    }
}
