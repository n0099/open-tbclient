package com.baidu.tieba.im.chat.snapGroup;

import android.os.Handler;
import com.baidu.tieba.im.model.cb;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends com.baidu.tbadk.coreExtra.c.c {
    final /* synthetic */ SnapGroupChatActivity a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(SnapGroupChatActivity snapGroupChatActivity, long j) {
        super(j, 1000L);
        this.a = snapGroupChatActivity;
    }

    @Override // com.baidu.tbadk.coreExtra.c.c
    public void a(long j) {
        SnapGroupChatView x;
        SnapGroupChatView x2;
        SnapGroupChatView x3;
        SnapGroupChatView x4;
        boolean z;
        if (j >= 30000) {
            return;
        }
        x = this.a.x();
        if (x.U().getVisibility() != 4) {
            return;
        }
        x2 = this.a.x();
        x2.U().setVisibility(0);
        x3 = this.a.x();
        x3.U().a(30000L, 1000L);
        x4 = this.a.x();
        x4.U().a();
        z = this.a.t;
        if (z) {
            this.a.showToast(this.a.getString(y.snap_group_chat_silence_warning), false);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.c.c
    public void c() {
        SnapGroupChatView x;
        com.baidu.tieba.im.chat.g gVar;
        cb cbVar;
        int i;
        Handler handler;
        x = this.a.x();
        x.U().setNoticeText(this.a.getString(y.snap_group_chat_kick_out_by_silence));
        gVar = this.a.d;
        gVar.Q();
        cbVar = this.a.m;
        i = this.a.p;
        cbVar.a(i, false, 1);
        handler = this.a.v;
        handler.postDelayed(new i(this), 3000L);
    }
}
