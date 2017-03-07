package com.baidu.tieba.g;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.newFriends.RequestUnreadPointNum;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Runnable {
    final /* synthetic */ a fdZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.fdZ = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        z = this.fdZ.fdR;
        if (!z) {
            MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
        }
    }
}
