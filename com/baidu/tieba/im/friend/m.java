package com.baidu.tieba.im.friend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements Runnable {
    final /* synthetic */ l a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.a = lVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        InviteFriendListActivity inviteFriendListActivity;
        InviteFriendListActivity inviteFriendListActivity2;
        inviteFriendListActivity = this.a.a;
        if (!inviteFriendListActivity.isFinishing()) {
            inviteFriendListActivity2 = this.a.a;
            inviteFriendListActivity2.finish();
        }
    }
}
