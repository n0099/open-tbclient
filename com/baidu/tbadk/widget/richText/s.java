package com.baidu.tbadk.widget.richText;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
class s implements View.OnTouchListener {
    final /* synthetic */ TbRichTextView aFD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(TbRichTextView tbRichTextView) {
        this.aFD = tbRichTextView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.aFD.aFt = true;
        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            this.aFD.aFt = false;
        }
        return false;
    }
}
