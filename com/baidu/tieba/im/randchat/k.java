package com.baidu.tieba.im.randchat;

import com.baidu.tieba.im.model.ar;
import com.baidu.tieba.im.randchat.WaitingTipView;
import com.baidu.tieba.util.bt;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends bt {
    final /* synthetic */ WaittingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(WaittingActivity waittingActivity, long j, long j2) {
        super(j, j2);
        this.a = waittingActivity;
    }

    @Override // com.baidu.tieba.util.bt
    public void a(long j) {
    }

    @Override // com.baidu.tieba.util.bt
    public void a() {
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
