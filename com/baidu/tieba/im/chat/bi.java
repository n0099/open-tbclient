package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bi implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bg f1529a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(bg bgVar) {
        this.f1529a = bgVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        aa aaVar;
        if (motionEvent.getAction() == 1) {
            this.f1529a.M();
        } else if (motionEvent.getAction() == 0) {
            this.f1529a.S();
            aaVar = this.f1529a.E;
            if (aaVar.a() == 0) {
                this.f1529a.N();
                this.f1529a.Q();
                return true;
            }
        }
        return false;
    }
}
