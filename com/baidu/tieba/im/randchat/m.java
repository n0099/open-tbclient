package com.baidu.tieba.im.randchat;

import android.util.Pair;
import com.baidu.tieba.im.model.bu;
import com.baidu.tieba.im.randchat.WaitingTipView;
/* loaded from: classes.dex */
final class m extends com.baidu.tbadk.coreExtra.c.b {
    final /* synthetic */ WaittingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(WaittingActivity waittingActivity, long j, long j2) {
        super(100000000L, 1000L);
        this.a = waittingActivity;
    }

    @Override // com.baidu.tbadk.coreExtra.c.b
    public final void a(long j) {
        bu buVar;
        com.baidu.tbadk.coreExtra.c.b bVar;
        bu buVar2;
        buVar = this.a.b;
        if (!buVar.a().isEmpty()) {
            buVar2 = this.a.b;
            Pair<WaitingTipView.Type, Object[]> removeFirst = buVar2.a().removeFirst();
            if (removeFirst != null) {
                this.a.b((WaitingTipView.Type) removeFirst.first, (Object[]) removeFirst.second);
                return;
            }
            return;
        }
        bVar = this.a.f;
        bVar.a();
    }

    @Override // com.baidu.tbadk.coreExtra.c.b
    public final void c() {
    }
}
