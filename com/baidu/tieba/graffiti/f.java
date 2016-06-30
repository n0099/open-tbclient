package com.baidu.tieba.graffiti;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnLongClickListener {
    final /* synthetic */ e ciP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.ciP = eVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.ciP.aeu();
        return true;
    }
}
