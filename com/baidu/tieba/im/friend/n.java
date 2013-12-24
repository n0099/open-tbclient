package com.baidu.tieba.im.friend;
/* loaded from: classes.dex */
class n implements Runnable {
    final /* synthetic */ InviteFriendListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(InviteFriendListActivity inviteFriendListActivity) {
        this.a = inviteFriendListActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.finish();
    }
}
