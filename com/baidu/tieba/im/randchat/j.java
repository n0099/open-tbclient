package com.baidu.tieba.im.randchat;

import com.baidu.tieba.im.model.ar;
import com.baidu.tieba.im.randchat.WaitingTipView;
import com.baidu.tieba.util.bv;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends bv {
    final /* synthetic */ WaittingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(WaittingActivity waittingActivity, long j, long j2) {
        super(j, j2);
        this.a = waittingActivity;
    }

    @Override // com.baidu.tieba.util.bv
    public void a(long j) {
    }

    @Override // com.baidu.tieba.util.bv
    public void a() {
        bv bvVar;
        ar arVar;
        bv bvVar2;
        bvVar = this.a.f;
        if (bvVar != null) {
            bvVar2 = this.a.f;
            bvVar2.b();
        }
        arVar = this.a.b;
        if (arVar.d() <= 4) {
            this.a.b(WaitingTipView.Type.WAIT_LONG, (Object[]) null);
        }
    }
}
