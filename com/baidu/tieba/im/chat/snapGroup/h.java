package com.baidu.tieba.im.chat.snapGroup;

import android.os.Handler;
import com.baidu.tieba.im.model.ca;
import com.baidu.tieba.u;
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
        if (x.T().getVisibility() != 4) {
            return;
        }
        x2 = this.a.x();
        x2.T().setVisibility(0);
        x3 = this.a.x();
        x3.T().a(30000L, 1000L);
        x4 = this.a.x();
        x4.T().a();
        z = this.a.t;
        if (z) {
            this.a.showToast(this.a.getString(u.snap_group_chat_silence_warning), false);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.c.c
    public void c() {
        SnapGroupChatView x;
        com.baidu.tieba.im.chat.h hVar;
        ca caVar;
        int i;
        Handler handler;
        x = this.a.x();
        x.T().setNoticeText(this.a.getString(u.snap_group_chat_kick_out_by_silence));
        hVar = this.a.d;
        hVar.P();
        caVar = this.a.m;
        i = this.a.p;
        caVar.a(i, false, 1);
        handler = this.a.v;
        handler.postDelayed(new i(this), 3000L);
    }
}
