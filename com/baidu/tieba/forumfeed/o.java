package com.baidu.tieba.forumfeed;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.b.aq;
/* loaded from: classes.dex */
final class o implements View.OnClickListener {
    final /* synthetic */ n a;
    private final /* synthetic */ Context b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar, Context context) {
        this.a = nVar;
        this.b = context;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2010010, new aq(this.b)));
    }
}
