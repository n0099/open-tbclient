package com.baidu.tieba.im.chat.snapGroup;

import com.baidu.tbadk.coreExtra.view.ap;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class e implements ap {
    final /* synthetic */ SnapGroupChatActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(SnapGroupChatActivity snapGroupChatActivity) {
        this.a = snapGroupChatActivity;
    }

    @Override // com.baidu.tbadk.coreExtra.view.ap
    public void a() {
        h hVar;
        SnapGroupChatView x;
        this.a.z();
        this.a.showToast(this.a.getString(u.snap_group_chat_finished));
        hVar = this.a.q;
        hVar.a();
        x = this.a.x();
        x.T().setVisibility(4);
        this.a.u = true;
    }
}
