package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class e implements View.OnClickListener {
    final /* synthetic */ c a;
    private final /* synthetic */ t b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, t tVar) {
        this.a = cVar;
        this.b = tVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Context context;
        com.baidu.tbadk.core.util.bg a = com.baidu.tbadk.core.util.bg.a();
        context = this.a.a;
        a.a(context, new String[]{this.b.d});
    }
}
