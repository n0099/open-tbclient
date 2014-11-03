package com.baidu.tieba.account.forbid;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ e agv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.agv = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.agv.agt = ((g) view.getTag()).mIndex;
        this.agv.notifyDataSetChanged();
    }
}
