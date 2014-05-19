package com.baidu.tieba.im.chat.snapGroup;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ SnapGroupChatActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(SnapGroupChatActivity snapGroupChatActivity) {
        this.a = snapGroupChatActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        String str2;
        this.a.y();
        SnapGroupChatActivity snapGroupChatActivity = this.a;
        str = this.a.w;
        str2 = this.a.x;
        snapGroupChatActivity.a(str, str2);
    }
}
