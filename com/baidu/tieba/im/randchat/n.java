package com.baidu.tieba.im.randchat;

import com.baidu.tieba.im.model.bv;
import com.baidu.tieba.im.randchat.WaitingTipView;
/* loaded from: classes.dex */
final class n extends com.baidu.tbadk.coreExtra.c.b {
    final /* synthetic */ WaittingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(WaittingActivity waittingActivity, long j, long j2) {
        super(120000L, 120000L);
        this.a = waittingActivity;
    }

    @Override // com.baidu.tbadk.coreExtra.c.b
    public final void a(long j) {
    }

    @Override // com.baidu.tbadk.coreExtra.c.b
    public final void c() {
        com.baidu.tbadk.coreExtra.c.b bVar;
        bv bvVar;
        com.baidu.tbadk.coreExtra.c.b bVar2;
        bVar = this.a.f;
        if (bVar != null) {
            bVar2 = this.a.f;
            bVar2.a();
        }
        bvVar = this.a.b;
        if (bvVar.d() <= 4) {
            this.a.b(WaitingTipView.Type.WAIT_LONG, (Object[]) null);
        }
    }
}
