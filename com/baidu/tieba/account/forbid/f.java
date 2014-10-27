package com.baidu.tieba.account.forbid;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ e agn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.agn = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.agn.agl = ((g) view.getTag()).mIndex;
        this.agn.notifyDataSetChanged();
    }
}
