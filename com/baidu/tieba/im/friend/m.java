package com.baidu.tieba.im.friend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements Runnable {
    final /* synthetic */ l bbO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.bbO = lVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        InviteFriendListActivity inviteFriendListActivity;
        InviteFriendListActivity inviteFriendListActivity2;
        inviteFriendListActivity = this.bbO.bbN;
        if (!inviteFriendListActivity.isFinishing()) {
            inviteFriendListActivity2 = this.bbO.bbN;
            inviteFriendListActivity2.finish();
        }
    }
}
