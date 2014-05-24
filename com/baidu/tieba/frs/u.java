package com.baidu.tieba.frs;

import android.text.TextUtils;
/* loaded from: classes.dex */
class u implements dp {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.tieba.frs.dp
    public void a(String str) {
        boolean z;
        com.baidu.tbadk.core.data.n nVar;
        z = this.a.k;
        if (z) {
            nVar = this.a.j;
            this.a.c(nVar.o().getIsLike() == 1 ? 0 : 1);
        }
        this.a.i = false;
        com.baidu.tieba.pb.main.bn.a().f();
    }

    @Override // com.baidu.tieba.frs.dp
    public void b(String str) {
        boolean z;
        z = this.a.k;
        if (z && !TextUtils.isEmpty(str)) {
            this.a.showToast(str);
        }
        this.a.i = false;
    }
}
