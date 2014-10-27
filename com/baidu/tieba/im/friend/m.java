package com.baidu.tieba.im.friend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements Runnable {
    final /* synthetic */ l aVO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.aVO = lVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        InviteFriendListActivity inviteFriendListActivity;
        InviteFriendListActivity inviteFriendListActivity2;
        inviteFriendListActivity = this.aVO.aVN;
        if (!inviteFriendListActivity.isFinishing()) {
            inviteFriendListActivity2 = this.aVO.aVN;
            inviteFriendListActivity2.finish();
        }
    }
}
