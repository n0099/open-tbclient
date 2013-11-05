package com.baidu.tieba.flist;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ x f1208a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(x xVar) {
        this.f1208a = xVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.f1208a.t.isShowing()) {
            this.f1208a.t.dismiss();
            return false;
        }
        return false;
    }
}
