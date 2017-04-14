package com.baidu.tieba.graffiti;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnLongClickListener {
    final /* synthetic */ d cnG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.cnG = dVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.cnG.agE();
        return true;
    }
}
