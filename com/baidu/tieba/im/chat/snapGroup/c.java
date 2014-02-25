package com.baidu.tieba.im.chat.snapGroup;
/* loaded from: classes.dex */
class c implements Runnable {
    final /* synthetic */ SnapGroupChatActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(SnapGroupChatActivity snapGroupChatActivity) {
        this.a = snapGroupChatActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        String str2;
        this.a.s();
        SnapGroupChatActivity snapGroupChatActivity = this.a;
        str = this.a.x;
        str2 = this.a.y;
        snapGroupChatActivity.a(str, str2);
    }
}
