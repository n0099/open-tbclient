package com.baidu.tieba.flist;

import android.view.KeyEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements View.OnKeyListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ y f1266a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar) {
        this.f1266a = yVar;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 4 && this.f1266a.s.isShowing()) {
            this.f1266a.s.dismiss();
            return false;
        }
        return false;
    }
}
