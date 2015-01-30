package com.baidu.tieba.account.forbid;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ e aoH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.aoH = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aoH.aoF = ((g) view.getTag()).mIndex;
        this.aoH.notifyDataSetChanged();
    }
}
