package com.baidu.tieba.home;

import android.content.Context;
import android.view.View;
import com.baidu.adp.lib.util.BdUtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class o implements View.OnClickListener {
    final /* synthetic */ n a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.a = nVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z;
        com.baidu.tieba.k kVar;
        String str;
        com.baidu.tieba.k kVar2;
        com.baidu.tieba.k kVar3;
        z = this.a.t;
        if (z) {
            kVar3 = this.a.d;
            SignAllForumActivity.a(kVar3);
        } else {
            kVar = this.a.d;
            str = this.a.u;
            BdUtilHelper.a((Context) kVar, str);
        }
        kVar2 = this.a.d;
        com.baidu.tieba.ai.a(kVar2, "signall_enter_click");
    }
}
