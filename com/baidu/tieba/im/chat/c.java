package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnTouchListener {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.a = aVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        EditText editText;
        if (motionEvent.getAction() == 1) {
            editText = this.a.E;
            editText.setCursorVisible(true);
            this.a.Q();
        } else if (motionEvent.getAction() == 0) {
            this.a.X();
            if (this.a.d.getVisibility() == 0) {
                this.a.R();
                this.a.U();
                this.a.W();
                return true;
            }
        }
        return false;
    }
}
