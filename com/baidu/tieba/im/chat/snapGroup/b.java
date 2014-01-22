package com.baidu.tieba.im.chat.snapGroup;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ SnapGroupChatActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(SnapGroupChatActivity snapGroupChatActivity) {
        this.a = snapGroupChatActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        String str2;
        this.a.s();
        SnapGroupChatActivity snapGroupChatActivity = this.a;
        str = this.a.y;
        str2 = this.a.z;
        snapGroupChatActivity.a(str, str2);
    }
}
