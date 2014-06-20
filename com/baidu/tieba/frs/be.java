package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class be implements View.OnClickListener {
    final /* synthetic */ az a;
    private final /* synthetic */ com.baidu.tbadk.core.data.b b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(az azVar, com.baidu.tbadk.core.data.b bVar) {
        this.a = azVar;
        this.b = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        String a = this.b.a();
        if (!com.baidu.tbadk.core.util.bg.c(a)) {
            com.baidu.tbadk.core.util.bk a2 = com.baidu.tbadk.core.util.bk.a();
            context = this.a.b;
            a2.a(context, new String[]{a});
        }
        com.baidu.tbadk.f.a().b(this.b.i(), System.currentTimeMillis());
    }
}
