package com.baidu.tieba.im.friend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements Runnable {
    final /* synthetic */ l bat;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.bat = lVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        InviteFriendListActivity inviteFriendListActivity;
        InviteFriendListActivity inviteFriendListActivity2;
        inviteFriendListActivity = this.bat.bas;
        if (!inviteFriendListActivity.isFinishing()) {
            inviteFriendListActivity2 = this.bat.bas;
            inviteFriendListActivity2.finish();
        }
    }
}
