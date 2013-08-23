package com.baidu.tieba.flist;

import android.view.KeyEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements View.OnKeyListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ w f1058a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar) {
        this.f1058a = wVar;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 4 && this.f1058a.t.isShowing()) {
            this.f1058a.t.dismiss();
            return false;
        }
        return false;
    }
}
