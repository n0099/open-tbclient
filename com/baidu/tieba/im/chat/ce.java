package com.baidu.tieba.im.chat;

import android.os.Handler;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class ce implements Runnable {
    final /* synthetic */ PersonalChatActivity aSN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ce(PersonalChatActivity personalChatActivity) {
        this.aSN = personalChatActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        UserData userData;
        com.baidu.tbadk.coreExtra.relationship.f fVar;
        long j;
        Handler handler;
        Runnable runnable;
        long j2;
        AbsMsglistView absMsglistView = this.aSN.mListView;
        userData = this.aSN.mUser;
        String userName = userData.getUserName();
        fVar = this.aSN.aSF;
        absMsglistView.refreshPersonalHeadFooter(userName, fVar);
        j = this.aSN.aSE;
        if (j != 0) {
            handler = this.aSN.mHandler;
            runnable = this.aSN.aSK;
            j2 = this.aSN.aSE;
            handler.postDelayed(runnable, j2);
        }
    }
}
