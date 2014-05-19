package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnTouchListener {
    final /* synthetic */ h a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar) {
        this.a = hVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.a.d.setCursorVisible(true);
            this.a.g();
        } else if (motionEvent.getAction() == 0) {
            this.a.U();
            if (this.a.e.getVisibility() == 0) {
                this.a.h();
                this.a.i();
                this.a.T();
                return true;
            }
        }
        return false;
    }
}
