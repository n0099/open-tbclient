package com.baidu.tieba.im.randchat;

import com.baidu.tieba.im.model.ar;
import com.baidu.tieba.im.randchat.WaitingTipView;
import com.baidu.tieba.util.bt;
/* loaded from: classes.dex */
final class m extends bt {
    final /* synthetic */ WaittingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(WaittingActivity waittingActivity, long j, long j2) {
        super(120000L, 120000L);
        this.a = waittingActivity;
    }

    @Override // com.baidu.tieba.util.bt
    public final void a(long j) {
    }

    @Override // com.baidu.tieba.util.bt
    public final void a() {
        bt btVar;
        ar arVar;
        bt btVar2;
        btVar = this.a.f;
        if (btVar != null) {
            btVar2 = this.a.f;
            btVar2.b();
        }
        arVar = this.a.b;
        if (arVar.d() <= 4) {
            this.a.b(WaitingTipView.Type.WAIT_LONG, (Object[]) null);
        }
    }
}
