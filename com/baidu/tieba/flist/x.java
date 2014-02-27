package com.baidu.tieba.flist;

import android.view.KeyEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class x implements View.OnKeyListener {
    final /* synthetic */ w a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar) {
        this.a = wVar;
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 4 && this.a.t.isShowing()) {
            this.a.t.dismiss();
            return false;
        }
        return false;
    }
}
