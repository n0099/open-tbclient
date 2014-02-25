package com.baidu.tieba.im.chat.snapGroup;

import android.os.Handler;
import com.baidu.tieba.im.model.ar;
import com.baidu.tieba.util.bt;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends bt {
    final /* synthetic */ SnapGroupChatActivity a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(SnapGroupChatActivity snapGroupChatActivity, long j) {
        super(j, 1000L);
        this.a = snapGroupChatActivity;
    }

    @Override // com.baidu.tieba.util.bt
    public void a(long j) {
        SnapGroupChatView r;
        SnapGroupChatView r2;
        SnapGroupChatView r3;
        SnapGroupChatView r4;
        boolean z;
        if (j >= 30000) {
            return;
        }
        r = this.a.r();
        if (r.U().getVisibility() != 4) {
            return;
        }
        r2 = this.a.r();
        r2.U().setVisibility(0);
        r3 = this.a.r();
        r3.U().a(30000L, 1000L);
        r4 = this.a.r();
        r4.U().a();
        z = this.a.u;
        if (z) {
            this.a.showToast(this.a.getString(R.string.snap_group_chat_silence_warning), false);
        }
    }

    @Override // com.baidu.tieba.util.bt
    public void a() {
        SnapGroupChatView r;
        com.baidu.tieba.im.chat.a aVar;
        ar arVar;
        int i;
        Handler handler;
        r = this.a.r();
        r.U().setNoticeText(this.a.getString(R.string.snap_group_chat_kick_out_by_silence));
        aVar = this.a.d;
        aVar.P();
        arVar = this.a.n;
        i = this.a.q;
        arVar.a(i, false, 1);
        handler = this.a.w;
        handler.postDelayed(new h(this), 3000L);
    }
}
