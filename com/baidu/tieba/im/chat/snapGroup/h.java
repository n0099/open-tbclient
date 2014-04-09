package com.baidu.tieba.im.chat.snapGroup;

import android.os.Handler;
import com.baidu.tieba.im.model.bv;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class h extends com.baidu.tbadk.coreExtra.c.b {
    final /* synthetic */ SnapGroupChatActivity a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(SnapGroupChatActivity snapGroupChatActivity, long j) {
        super(j, 1000L);
        this.a = snapGroupChatActivity;
    }

    @Override // com.baidu.tbadk.coreExtra.c.b
    public final void a(long j) {
        boolean z;
        if (j < 30000 && SnapGroupChatActivity.d(this.a).U().getVisibility() == 4) {
            SnapGroupChatActivity.d(this.a).U().setVisibility(0);
            SnapGroupChatActivity.d(this.a).U().a(30000L, 1000L);
            SnapGroupChatActivity.d(this.a).U().a();
            z = this.a.s;
            if (z) {
                this.a.showToast(this.a.getString(com.baidu.tieba.im.j.snap_group_chat_silence_warning), false);
            }
        }
    }

    @Override // com.baidu.tbadk.coreExtra.c.b
    public final void c() {
        com.baidu.tieba.im.chat.h hVar;
        bv bvVar;
        int i;
        Handler handler;
        SnapGroupChatActivity.d(this.a).U().setNoticeText(this.a.getString(com.baidu.tieba.im.j.snap_group_chat_kick_out_by_silence));
        hVar = this.a.d;
        hVar.Q();
        bvVar = this.a.l;
        i = this.a.o;
        bvVar.a(i, false, 1);
        handler = this.a.u;
        handler.postDelayed(new i(this), 3000L);
    }
}
