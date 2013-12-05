package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bo implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bm f1573a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(bm bmVar) {
        this.f1573a = bmVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        ad adVar;
        if (motionEvent.getAction() == 1) {
            this.f1573a.K();
        } else if (motionEvent.getAction() == 0) {
            this.f1573a.Q();
            adVar = this.f1573a.E;
            if (adVar.a() == 0) {
                this.f1573a.L();
                this.f1573a.O();
                return true;
            }
        }
        return false;
    }
}
