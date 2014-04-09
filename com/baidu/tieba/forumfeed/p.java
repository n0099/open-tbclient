package com.baidu.tieba.forumfeed;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.b.aq;
/* loaded from: classes.dex */
final class p implements View.OnClickListener {
    final /* synthetic */ o a;
    private final /* synthetic */ Context b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar, Context context) {
        this.a = oVar;
        this.b = context;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2010010, new aq(this.b)));
    }
}
