package com.baidu.tieba.h;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.newFriends.RequestUnreadPointNum;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Runnable {
    final /* synthetic */ a fdP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.fdP = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        z = this.fdP.fdH;
        if (!z) {
            MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
        }
    }
}
