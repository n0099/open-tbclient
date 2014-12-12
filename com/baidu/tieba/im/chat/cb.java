package com.baidu.tieba.im.chat;

import android.os.Handler;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class cb implements Runnable {
    final /* synthetic */ PersonalChatActivity aRE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cb(PersonalChatActivity personalChatActivity) {
        this.aRE = personalChatActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        UserData userData;
        com.baidu.tbadk.coreExtra.relationship.f fVar;
        long j;
        Handler handler;
        Runnable runnable;
        long j2;
        AbsMsglistView absMsglistView = this.aRE.mListView;
        userData = this.aRE.mUser;
        String userName = userData.getUserName();
        fVar = this.aRE.aRw;
        absMsglistView.refreshPersonalHeadFooter(userName, fVar);
        j = this.aRE.aRv;
        if (j != 0) {
            handler = this.aRE.mHandler;
            runnable = this.aRE.aRB;
            j2 = this.aRE.aRv;
            handler.postDelayed(runnable, j2);
        }
    }
}
