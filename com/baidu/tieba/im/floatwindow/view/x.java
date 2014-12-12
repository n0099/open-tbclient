package com.baidu.tieba.im.floatwindow.view;

import android.os.Handler;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class x implements Runnable {
    final /* synthetic */ FloatingPersonalChatActivity aYF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(FloatingPersonalChatActivity floatingPersonalChatActivity) {
        this.aYF = floatingPersonalChatActivity;
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
        userData = this.aYF.mUser;
        if (userData == null) {
            return;
        }
        floatingPersonalChatView = this.aYF.aYD;
        userData2 = this.aYF.mUser;
        String userName = userData2.getUserName();
        fVar = this.aYF.aRw;
        floatingPersonalChatView.a(userName, fVar);
        j = this.aYF.aRv;
        if (j != 0) {
            handler = this.aYF.mHandler;
            runnable = this.aYF.aRB;
            j2 = this.aYF.aRv;
            handler.postDelayed(runnable, j2);
        }
    }
}
