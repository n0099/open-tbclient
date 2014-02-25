package com.baidu.tieba.im.chat.snapGroup;

import com.baidu.tieba.view.ce;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class d implements ce {
    final /* synthetic */ SnapGroupChatActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(SnapGroupChatActivity snapGroupChatActivity) {
        this.a = snapGroupChatActivity;
    }

    @Override // com.baidu.tieba.view.ce
    public void a() {
        g gVar;
        SnapGroupChatView r;
        this.a.t();
        this.a.showToast(this.a.getString(R.string.snap_group_chat_finished));
        gVar = this.a.r;
        gVar.b();
        r = this.a.r();
        r.U().setVisibility(4);
        this.a.v = true;
    }
}
