package com.baidu.tieba.im.chat.snapGroup;
/* loaded from: classes.dex */
final class c implements Runnable {
    final /* synthetic */ SnapGroupChatActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(SnapGroupChatActivity snapGroupChatActivity) {
        this.a = snapGroupChatActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        String str2;
        SnapGroupChatActivity.i(this.a);
        SnapGroupChatActivity snapGroupChatActivity = this.a;
        str = this.a.x;
        str2 = this.a.y;
        SnapGroupChatActivity.a(snapGroupChatActivity, str, str2);
    }
}
