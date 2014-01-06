package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import com.baidu.tieba.editortool.EmotionTabHost;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bu implements View.OnTouchListener {
    final /* synthetic */ bs a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bu(bs bsVar) {
        this.a = bsVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        EmotionTabHost emotionTabHost;
        EditText editText;
        if (motionEvent.getAction() == 1) {
            editText = this.a.z;
            editText.setCursorVisible(true);
            this.a.N();
        } else if (motionEvent.getAction() == 0) {
            this.a.U();
            emotionTabHost = this.a.E;
            if (emotionTabHost.getVisibility() == 0) {
                this.a.O();
                this.a.R();
                this.a.T();
                return true;
            }
        }
        return false;
    }
}
