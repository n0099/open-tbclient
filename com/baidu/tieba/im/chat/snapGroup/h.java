package com.baidu.tieba.im.chat.snapGroup;

import android.os.Handler;
import com.baidu.tieba.im.model.bf;
import com.baidu.tieba.x;
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
        SnapGroupChatView w;
        SnapGroupChatView w2;
        SnapGroupChatView w3;
        SnapGroupChatView w4;
        SnapGroupChatView w5;
        boolean z;
        w = this.a.w();
        if (w == null || j >= 30000) {
            return;
        }
        w2 = this.a.w();
        if (w2.V().getVisibility() != 4) {
            return;
        }
        w3 = this.a.w();
        w3.V().setVisibility(0);
        w4 = this.a.w();
        w4.V().a(30000L, 1000L);
        w5 = this.a.w();
        w5.V().a();
        z = this.a.t;
        if (z) {
            this.a.showToast(this.a.getString(x.snap_group_chat_silence_warning), false);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.c.c
    public void c() {
        SnapGroupChatView w;
        SnapGroupChatView w2;
        com.baidu.tieba.im.chat.g gVar;
        bf bfVar;
        int i;
        Handler handler;
        SnapGroupChatView w3;
        w = this.a.w();
        if (w == null) {
            return;
        }
        w2 = this.a.w();
        if (w2.V() != null) {
            w3 = this.a.w();
            w3.V().setNoticeText(this.a.getString(x.snap_group_chat_kick_out_by_silence));
        }
        gVar = this.a.d;
        gVar.R();
        bfVar = this.a.m;
        i = this.a.p;
        bfVar.a(i, false, 1);
        handler = this.a.v;
        handler.postDelayed(new i(this), 3000L);
    }
}
