package com.baidu.tieba.im.chat;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c implements View.OnTouchListener {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.a = aVar;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        EditText editText;
        if (motionEvent.getAction() == 1) {
            editText = this.a.G;
            editText.setCursorVisible(true);
            this.a.P();
        } else if (motionEvent.getAction() == 0) {
            this.a.U();
            if (this.a.e.getVisibility() == 0) {
                this.a.Q();
                this.a.T();
                new Handler().postDelayed(new e(this.a), 100L);
                return true;
            }
        }
        return false;
    }
}
