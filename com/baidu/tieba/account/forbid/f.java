package com.baidu.tieba.account.forbid;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class f implements View.OnClickListener {
    final /* synthetic */ e a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.a = eVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.b = ((g) view.getTag()).c;
        this.a.notifyDataSetChanged();
    }
}
