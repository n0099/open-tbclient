package com.baidu.tieba.frs;

import android.text.TextUtils;
/* loaded from: classes.dex */
class u implements dq {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.tieba.frs.dq
    public void a(String str) {
        boolean z;
        com.baidu.tbadk.core.data.m mVar;
        z = this.a.j;
        if (z) {
            mVar = this.a.i;
            this.a.c(mVar.o().getIsLike() == 1 ? 0 : 1);
        }
        this.a.h = false;
        com.baidu.tieba.pb.main.bq.a().f();
    }

    @Override // com.baidu.tieba.frs.dq
    public void b(String str) {
        boolean z;
        z = this.a.j;
        if (z && !TextUtils.isEmpty(str)) {
            this.a.showToast(str);
        }
        this.a.h = false;
    }
}
