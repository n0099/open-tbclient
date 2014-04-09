package com.baidu.tieba.im.chat;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class j implements View.OnTouchListener {
    final /* synthetic */ h a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar) {
        this.a = hVar;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        EditText editText;
        if (motionEvent.getAction() == 1) {
            editText = this.a.H;
            editText.setCursorVisible(true);
            this.a.R();
        } else if (motionEvent.getAction() == 0) {
            this.a.W();
            if (this.a.d.getVisibility() == 0) {
                this.a.S();
                this.a.V();
                new Handler().postDelayed(new l(this.a), 100L);
                return true;
            }
        }
        return false;
    }
}
