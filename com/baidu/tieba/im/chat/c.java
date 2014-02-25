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
            editText = this.a.G;
            editText.setCursorVisible(true);
            this.a.S();
        } else if (motionEvent.getAction() == 0) {
            this.a.Z();
            if (this.a.e.getVisibility() == 0) {
                this.a.T();
                this.a.W();
                this.a.Y();
                return true;
            }
        }
        return false;
    }
}
