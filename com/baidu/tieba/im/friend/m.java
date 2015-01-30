package com.baidu.tieba.im.friend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements Runnable {
    final /* synthetic */ l bbP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.bbP = lVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        InviteFriendListActivity inviteFriendListActivity;
        InviteFriendListActivity inviteFriendListActivity2;
        inviteFriendListActivity = this.bbP.bbO;
        if (!inviteFriendListActivity.isFinishing()) {
            inviteFriendListActivity2 = this.bbP.bbO;
            inviteFriendListActivity2.finish();
        }
    }
}
