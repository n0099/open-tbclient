package com.baidu.tieba.graffiti;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnLongClickListener {
    final /* synthetic */ d cmW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.cmW = dVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.cmW.afo();
        return true;
    }
}
