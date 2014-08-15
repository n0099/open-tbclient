package com.baidu.tieba.frs;

import android.text.TextUtils;
/* loaded from: classes.dex */
class v implements dt {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.tieba.frs.dt
    public void a(String str) {
        boolean z;
        com.baidu.tbadk.core.data.n nVar;
        com.baidu.tbadk.core.data.n nVar2;
        int i = 1;
        z = this.a.k;
        if (z) {
            nVar = this.a.j;
            if (nVar != null) {
                nVar2 = this.a.j;
                if (nVar2.g().getIsLike() == 1) {
                    i = 0;
                }
            }
            this.a.d(i);
        }
        this.a.i = false;
        com.baidu.tieba.pb.main.bp.a().f();
    }

    @Override // com.baidu.tieba.frs.dt
    public void b(String str) {
        boolean z;
        z = this.a.k;
        if (z && !TextUtils.isEmpty(str)) {
            this.a.showToast(str);
        }
        this.a.i = false;
    }
}
