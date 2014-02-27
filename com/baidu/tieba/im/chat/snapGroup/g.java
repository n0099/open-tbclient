package com.baidu.tieba.im.chat.snapGroup;

import android.os.Handler;
import com.baidu.tieba.im.model.ar;
import com.baidu.tieba.util.bt;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class g extends bt {
    final /* synthetic */ SnapGroupChatActivity a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(SnapGroupChatActivity snapGroupChatActivity, long j) {
        super(j, 1000L);
        this.a = snapGroupChatActivity;
    }

    @Override // com.baidu.tieba.util.bt
    public final void a(long j) {
        boolean z;
        if (j < 30000 && SnapGroupChatActivity.d(this.a).S().getVisibility() == 4) {
            SnapGroupChatActivity.d(this.a).S().setVisibility(0);
            SnapGroupChatActivity.d(this.a).S().a(30000L, 1000L);
            SnapGroupChatActivity.d(this.a).S().a();
            z = this.a.u;
            if (z) {
                this.a.showToast(this.a.getString(R.string.snap_group_chat_silence_warning), false);
            }
        }
    }

    @Override // com.baidu.tieba.util.bt
    public final void a() {
        com.baidu.tieba.im.chat.a aVar;
        ar arVar;
        int i;
        Handler handler;
        SnapGroupChatActivity.d(this.a).S().setNoticeText(this.a.getString(R.string.snap_group_chat_kick_out_by_silence));
        aVar = this.a.d;
        aVar.N();
        arVar = this.a.n;
        i = this.a.q;
        arVar.a(i, false, 1);
        handler = this.a.w;
        handler.postDelayed(new h(this), 3000L);
    }
}
