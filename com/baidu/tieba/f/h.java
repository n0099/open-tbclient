package com.baidu.tieba.f;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.newFriends.RequestUnreadPointNum;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Runnable {
    final /* synthetic */ a eQj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.eQj = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        z = this.eQj.eQb;
        if (!z) {
            MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
        }
    }
}
