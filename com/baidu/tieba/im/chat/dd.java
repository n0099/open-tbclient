package com.baidu.tieba.im.chat;

import android.os.Handler;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class dd implements Runnable {
    final /* synthetic */ PersonalChatActivity aPI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dd(PersonalChatActivity personalChatActivity) {
        this.aPI = personalChatActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        UserData userData;
        com.baidu.tbadk.coreExtra.relationship.f fVar;
        long j;
        Handler handler;
        Runnable runnable;
        long j2;
        AbsMsglistView absMsglistView = this.aPI.aPP;
        userData = this.aPI.mUser;
        String userName = userData.getUserName();
        fVar = this.aPI.aPC;
        absMsglistView.refreshPersonalHeadFooter(userName, fVar);
        j = this.aPI.aPB;
        if (j != 0) {
            handler = this.aPI.mHandler;
            runnable = this.aPI.aPF;
            j2 = this.aPI.aPB;
            handler.postDelayed(runnable, j2);
        }
    }
}
