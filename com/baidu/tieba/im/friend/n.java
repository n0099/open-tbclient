package com.baidu.tieba.im.friend;
/* loaded from: classes.dex */
final class n implements Runnable {
    final /* synthetic */ InviteFriendListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(InviteFriendListActivity inviteFriendListActivity) {
        this.a = inviteFriendListActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.finish();
    }
}
