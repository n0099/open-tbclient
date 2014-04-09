package com.baidu.tieba.frs;

import android.text.TextUtils;
/* loaded from: classes.dex */
final class v implements dg {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.tieba.frs.dg
    public final void a() {
        com.baidu.tbadk.core.data.o oVar;
        oVar = this.a.f;
        FrsActivity.e(this.a, oVar.k().getIsLike() == 1 ? 0 : 1);
        this.a.e = false;
    }

    @Override // com.baidu.tieba.frs.dg
    public final void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.a.showToast(str);
        }
        this.a.e = false;
    }
}
