package com.baidu.tbadk.widget.richText;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
class q implements View.OnTouchListener {
    final /* synthetic */ TbRichTextView aJw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(TbRichTextView tbRichTextView) {
        this.aJw = tbRichTextView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.aJw.aJr = true;
        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            this.aJw.aJr = false;
        }
        return false;
    }
}
