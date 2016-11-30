package com.baidu.tieba.graffiti;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnLongClickListener {
    final /* synthetic */ e cCc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.cCc = eVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.cCc.alR();
        return true;
    }
}
