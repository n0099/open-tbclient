package com.baidu.tieba.flist;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ w f1059a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(w wVar) {
        this.f1059a = wVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.f1059a.t.isShowing()) {
            this.f1059a.t.dismiss();
            return false;
        }
        return false;
    }
}
