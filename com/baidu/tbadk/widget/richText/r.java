package com.baidu.tbadk.widget.richText;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
class r implements View.OnTouchListener {
    final /* synthetic */ TbRichTextView aJR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(TbRichTextView tbRichTextView) {
        this.aJR = tbRichTextView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.aJR.aJH = true;
        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            this.aJR.aJH = false;
        }
        return false;
    }
}
