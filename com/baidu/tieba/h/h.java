package com.baidu.tieba.h;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.newFriends.RequestUnreadPointNum;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Runnable {
    final /* synthetic */ a eZE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.eZE = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        z = this.eZE.eZw;
        if (!z) {
            MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
        }
    }
}
