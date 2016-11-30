package com.baidu.tbadk.widget.richText;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
class s implements View.OnTouchListener {
    final /* synthetic */ TbRichTextView aKA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(TbRichTextView tbRichTextView) {
        this.aKA = tbRichTextView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.aKA.aKq = true;
        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            this.aKA.aKq = false;
        }
        return false;
    }
}
