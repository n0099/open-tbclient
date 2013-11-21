package com.baidu.tieba.flist;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ y f1241a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(y yVar) {
        this.f1241a = yVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.f1241a.s.isShowing()) {
            this.f1241a.s.dismiss();
            return false;
        }
        return false;
    }
}
