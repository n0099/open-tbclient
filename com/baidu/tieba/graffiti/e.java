package com.baidu.tieba.graffiti;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnLongClickListener {
    final /* synthetic */ d cBh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.cBh = dVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.cBh.akn();
        return true;
    }
}
