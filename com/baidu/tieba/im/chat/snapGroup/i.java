package com.baidu.tieba.im.chat.snapGroup;

import com.baidu.tieba.y;
/* loaded from: classes.dex */
class i implements Runnable {
    final /* synthetic */ h a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.a = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        SnapGroupChatActivity snapGroupChatActivity;
        SnapGroupChatActivity snapGroupChatActivity2;
        boolean z;
        SnapGroupChatActivity snapGroupChatActivity3;
        SnapGroupChatActivity snapGroupChatActivity4;
        snapGroupChatActivity = this.a.a;
        snapGroupChatActivity.finish();
        snapGroupChatActivity2 = this.a.a;
        z = snapGroupChatActivity2.t;
        if (z) {
            snapGroupChatActivity3 = this.a.a;
            snapGroupChatActivity4 = this.a.a;
            snapGroupChatActivity3.showToast(snapGroupChatActivity4.getString(y.snap_group_chat_kick_out_by_silence), false);
        }
    }
}
