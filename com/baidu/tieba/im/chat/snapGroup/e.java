package com.baidu.tieba.im.chat.snapGroup;

import com.baidu.tbadk.coreExtra.view.ac;
/* loaded from: classes.dex */
final class e implements ac {
    final /* synthetic */ SnapGroupChatActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(SnapGroupChatActivity snapGroupChatActivity) {
        this.a = snapGroupChatActivity;
    }

    @Override // com.baidu.tbadk.coreExtra.view.ac
    public final void a() {
        h hVar;
        SnapGroupChatActivity.l(this.a);
        this.a.showToast(this.a.getString(com.baidu.tieba.im.j.snap_group_chat_finished));
        hVar = this.a.p;
        hVar.a();
        SnapGroupChatActivity.d(this.a).U().setVisibility(4);
        this.a.t = true;
    }
}
