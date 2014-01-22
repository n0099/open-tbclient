package com.baidu.tieba.im.randchat;

import android.util.Pair;
import com.baidu.tieba.im.model.ar;
import com.baidu.tieba.im.randchat.WaitingTipView;
import com.baidu.tieba.util.bv;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends bv {
    final /* synthetic */ WaittingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(WaittingActivity waittingActivity, long j, long j2) {
        super(j, j2);
        this.a = waittingActivity;
    }

    @Override // com.baidu.tieba.util.bv
    public void a(long j) {
        ar arVar;
        bv bvVar;
        ar arVar2;
        arVar = this.a.b;
        if (!arVar.a().isEmpty()) {
            arVar2 = this.a.b;
            Pair<WaitingTipView.Type, Object[]> removeFirst = arVar2.a().removeFirst();
            if (removeFirst != null) {
                this.a.b((WaitingTipView.Type) removeFirst.first, (Object[]) removeFirst.second);
                return;
            }
            return;
        }
        bvVar = this.a.f;
        bvVar.b();
    }

    @Override // com.baidu.tieba.util.bv
    public void a() {
    }
}
