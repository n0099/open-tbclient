package com.baidu.tieba.im.chat.snapGroup;

import com.baidu.tieba.view.ce;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
final class d implements ce {
    final /* synthetic */ SnapGroupChatActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(SnapGroupChatActivity snapGroupChatActivity) {
        this.a = snapGroupChatActivity;
    }

    @Override // com.baidu.tieba.view.ce
    public final void a() {
        g gVar;
        SnapGroupChatActivity.l(this.a);
        this.a.showToast(this.a.getString(R.string.snap_group_chat_finished));
        gVar = this.a.r;
        gVar.b();
        SnapGroupChatActivity.d(this.a).S().setVisibility(4);
        this.a.v = true;
    }
}
