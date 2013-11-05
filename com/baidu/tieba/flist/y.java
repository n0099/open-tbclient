package com.baidu.tieba.flist;

import android.view.KeyEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements View.OnKeyListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ x f1207a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar) {
        this.f1207a = xVar;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 4 && this.f1207a.t.isShowing()) {
            this.f1207a.t.dismiss();
            return false;
        }
        return false;
    }
}
