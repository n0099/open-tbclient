package com.baidu.tieba.im.chat.snapGroup;
/* loaded from: classes.dex */
final class d implements Runnable {
    final /* synthetic */ SnapGroupChatActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(SnapGroupChatActivity snapGroupChatActivity) {
        this.a = snapGroupChatActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        String str2;
        SnapGroupChatActivity.i(this.a);
        SnapGroupChatActivity snapGroupChatActivity = this.a;
        str = this.a.v;
        str2 = this.a.w;
        SnapGroupChatActivity.a(snapGroupChatActivity, str, str2);
    }
}
