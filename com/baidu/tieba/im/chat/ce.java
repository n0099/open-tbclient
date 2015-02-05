package com.baidu.tieba.im.chat;

import android.os.Handler;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class ce implements Runnable {
    final /* synthetic */ PersonalChatActivity aSM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ce(PersonalChatActivity personalChatActivity) {
        this.aSM = personalChatActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        UserData userData;
        com.baidu.tbadk.coreExtra.relationship.f fVar;
        long j;
        Handler handler;
        Runnable runnable;
        long j2;
        AbsMsglistView absMsglistView = this.aSM.mListView;
        userData = this.aSM.mUser;
        String userName = userData.getUserName();
        fVar = this.aSM.aSE;
        absMsglistView.refreshPersonalHeadFooter(userName, fVar);
        j = this.aSM.aSD;
        if (j != 0) {
            handler = this.aSM.mHandler;
            runnable = this.aSM.aSJ;
            j2 = this.aSM.aSD;
            handler.postDelayed(runnable, j2);
        }
    }
}
