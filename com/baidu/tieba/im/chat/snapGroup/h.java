package com.baidu.tieba.im.chat.snapGroup;

import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ g a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.a = gVar;
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
        z = snapGroupChatActivity2.u;
        if (z) {
            snapGroupChatActivity3 = this.a.a;
            snapGroupChatActivity4 = this.a.a;
            snapGroupChatActivity3.showToast(snapGroupChatActivity4.getString(R.string.snap_group_chat_kick_out_by_silence), false);
        }
    }
}
