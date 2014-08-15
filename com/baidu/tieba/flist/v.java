package com.baidu.tieba.flist;

import android.view.KeyEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements View.OnKeyListener {
    final /* synthetic */ u a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar) {
        this.a = uVar;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 4 && this.a.u.isShowing()) {
            this.a.u.dismiss();
            return false;
        }
        return false;
    }
}
