package com.baidu.tieba.frs;

import android.text.TextUtils;
/* loaded from: classes.dex */
class v implements Cdo {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.tieba.frs.Cdo
    public void a(String str) {
        boolean z;
        com.baidu.tbadk.core.data.o oVar;
        z = this.a.k;
        if (z) {
            oVar = this.a.j;
            this.a.c(oVar.j().getIsLike() == 1 ? 0 : 1);
        }
        this.a.i = false;
        com.baidu.tieba.pb.main.bg.a().f();
    }

    @Override // com.baidu.tieba.frs.Cdo
    public void b(String str) {
        boolean z;
        z = this.a.k;
        if (z && !TextUtils.isEmpty(str)) {
            this.a.showToast(str);
        }
        this.a.i = false;
    }
}
