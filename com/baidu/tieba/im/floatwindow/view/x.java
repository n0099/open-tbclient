package com.baidu.tieba.im.floatwindow.view;

import android.os.Handler;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class x implements Runnable {
    final /* synthetic */ FloatingPersonalChatActivity bab;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(FloatingPersonalChatActivity floatingPersonalChatActivity) {
        this.bab = floatingPersonalChatActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        UserData userData;
        FloatingPersonalChatView floatingPersonalChatView;
        UserData userData2;
        com.baidu.tbadk.coreExtra.relationship.f fVar;
        long j;
        Handler handler;
        Runnable runnable;
        long j2;
        userData = this.bab.mUser;
        if (userData == null) {
            return;
        }
        floatingPersonalChatView = this.bab.aZZ;
        userData2 = this.bab.mUser;
        String userName = userData2.getUserName();
        fVar = this.bab.aSF;
        floatingPersonalChatView.a(userName, fVar);
        j = this.bab.aSE;
        if (j != 0) {
            handler = this.bab.mHandler;
            runnable = this.bab.aSK;
            j2 = this.bab.aSE;
            handler.postDelayed(runnable, j2);
        }
    }
}
