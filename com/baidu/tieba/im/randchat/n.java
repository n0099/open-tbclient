package com.baidu.tieba.im.randchat;

import com.baidu.tieba.im.model.bf;
import com.baidu.tieba.im.randchat.WaitingTipView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends com.baidu.tbadk.coreExtra.c.c {
    final /* synthetic */ WaittingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(WaittingActivity waittingActivity, long j, long j2) {
        super(j, j2);
        this.a = waittingActivity;
    }

    @Override // com.baidu.tbadk.coreExtra.c.c
    public void a(long j) {
    }

    @Override // com.baidu.tbadk.coreExtra.c.c
    public void c() {
        com.baidu.tbadk.coreExtra.c.c cVar;
        bf bfVar;
        com.baidu.tbadk.coreExtra.c.c cVar2;
        cVar = this.a.f;
        if (cVar != null) {
            cVar2 = this.a.f;
            cVar2.a();
        }
        bfVar = this.a.b;
        if (bfVar.d() <= 4) {
            this.a.b(WaitingTipView.Type.WAIT_LONG, (Object[]) null);
        }
    }
}
