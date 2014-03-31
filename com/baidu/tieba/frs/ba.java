package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
/* loaded from: classes.dex */
final class ba implements View.OnClickListener {
    final /* synthetic */ ay a;
    private final /* synthetic */ com.baidu.tbadk.core.data.o b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(ay ayVar, com.baidu.tbadk.core.data.o oVar) {
        this.a = ayVar;
        this.b = oVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Context context;
        com.baidu.adp.framework.c a = com.baidu.adp.framework.c.a();
        context = this.a.a;
        a.a(new com.baidu.adp.framework.message.a(2001003, new com.baidu.tbadk.core.b.ag(context, this.b.t().getUserId(), this.b.t().getName_show())));
    }
}
