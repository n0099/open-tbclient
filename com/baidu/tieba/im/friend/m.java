package com.baidu.tieba.im.friend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements Runnable {
    final /* synthetic */ l aWc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.aWc = lVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        InviteFriendListActivity inviteFriendListActivity;
        InviteFriendListActivity inviteFriendListActivity2;
        inviteFriendListActivity = this.aWc.aWb;
        if (!inviteFriendListActivity.isFinishing()) {
            inviteFriendListActivity2 = this.aWc.aWb;
            inviteFriendListActivity2.finish();
        }
    }
}
