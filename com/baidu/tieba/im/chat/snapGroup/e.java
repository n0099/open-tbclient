package com.baidu.tieba.im.chat.snapGroup;

import com.baidu.tbadk.coreExtra.view.ar;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
class e implements ar {
    final /* synthetic */ SnapGroupChatActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(SnapGroupChatActivity snapGroupChatActivity) {
        this.a = snapGroupChatActivity;
    }

    @Override // com.baidu.tbadk.coreExtra.view.ar
    public void a() {
        h hVar;
        SnapGroupChatView w;
        this.a.y();
        this.a.showToast(this.a.getString(x.snap_group_chat_finished));
        hVar = this.a.q;
        hVar.a();
        w = this.a.w();
        w.V().setVisibility(4);
        this.a.u = true;
    }
}
