package com.baidu.tieba.im.floatwindow.view;

import android.os.Handler;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class x implements Runnable {
    final /* synthetic */ FloatingPersonalChatActivity baa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(FloatingPersonalChatActivity floatingPersonalChatActivity) {
        this.baa = floatingPersonalChatActivity;
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
        userData = this.baa.mUser;
        if (userData == null) {
            return;
        }
        floatingPersonalChatView = this.baa.aZY;
        userData2 = this.baa.mUser;
        String userName = userData2.getUserName();
        fVar = this.baa.aSE;
        floatingPersonalChatView.a(userName, fVar);
        j = this.baa.aSD;
        if (j != 0) {
            handler = this.baa.mHandler;
            runnable = this.baa.aSJ;
            j2 = this.baa.aSD;
            handler.postDelayed(runnable, j2);
        }
    }
}
