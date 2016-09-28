package com.baidu.tieba.f;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.newFriends.RequestUnreadPointNum;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ a feW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(a aVar) {
        this.feW = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        z = this.feW.feP;
        if (!z) {
            MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
        }
    }
}
