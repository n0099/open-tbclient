package com.baidu.tieba.im.chat;

import android.os.Handler;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class dd implements Runnable {
    final /* synthetic */ PersonalChatActivity aPW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dd(PersonalChatActivity personalChatActivity) {
        this.aPW = personalChatActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        UserData userData;
        com.baidu.tbadk.coreExtra.relationship.f fVar;
        long j;
        Handler handler;
        Runnable runnable;
        long j2;
        AbsMsglistView absMsglistView = this.aPW.aQd;
        userData = this.aPW.mUser;
        String userName = userData.getUserName();
        fVar = this.aPW.aPQ;
        absMsglistView.refreshPersonalHeadFooter(userName, fVar);
        j = this.aPW.aPP;
        if (j != 0) {
            handler = this.aPW.mHandler;
            runnable = this.aPW.aPT;
            j2 = this.aPW.aPP;
            handler.postDelayed(runnable, j2);
        }
    }
}
