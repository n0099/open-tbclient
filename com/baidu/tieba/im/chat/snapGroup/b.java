package com.baidu.tieba.im.chat.snapGroup;

import android.view.View;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
final class b implements View.OnClickListener {
    final /* synthetic */ SnapGroupChatActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(SnapGroupChatActivity snapGroupChatActivity) {
        this.a = snapGroupChatActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.showToast(this.a.getString(R.string.snap_group_chat_change_group_limit_tip));
    }
}
