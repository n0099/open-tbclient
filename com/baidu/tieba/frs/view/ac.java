package com.baidu.tieba.frs.view;

import android.view.KeyEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements View.OnKeyListener {
    final /* synthetic */ ab brV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(ab abVar) {
        this.brV = abVar;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.brV.SC();
            return true;
        }
        return false;
    }
}
