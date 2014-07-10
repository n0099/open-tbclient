package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnTouchListener {
    final /* synthetic */ g a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar) {
        this.a = gVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.a.d.setCursorVisible(true);
            this.a.g();
        } else if (motionEvent.getAction() == 0) {
            this.a.W();
            if (this.a.e.getVisibility() == 0) {
                this.a.h();
                this.a.i();
                this.a.V();
                return true;
            }
        }
        return false;
    }
}
