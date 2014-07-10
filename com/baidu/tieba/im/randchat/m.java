package com.baidu.tieba.im.randchat;

import android.util.Pair;
import com.baidu.tieba.im.model.ca;
import com.baidu.tieba.im.randchat.WaitingTipView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends com.baidu.tbadk.coreExtra.c.c {
    final /* synthetic */ WaittingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(WaittingActivity waittingActivity, long j, long j2) {
        super(j, j2);
        this.a = waittingActivity;
    }

    @Override // com.baidu.tbadk.coreExtra.c.c
    public void a(long j) {
        ca caVar;
        com.baidu.tbadk.coreExtra.c.c cVar;
        ca caVar2;
        caVar = this.a.b;
        if (!caVar.a().isEmpty()) {
            caVar2 = this.a.b;
            Pair<WaitingTipView.Type, Object[]> removeFirst = caVar2.a().removeFirst();
            if (removeFirst != null) {
                this.a.b((WaitingTipView.Type) removeFirst.first, (Object[]) removeFirst.second);
                return;
            }
            return;
        }
        cVar = this.a.f;
        cVar.a();
    }

    @Override // com.baidu.tbadk.coreExtra.c.c
    public void c() {
    }
}
