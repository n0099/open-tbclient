package com.baidu.tbadk.widget.richText;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
class i implements View.OnTouchListener {
    final /* synthetic */ TbRichTextView aOG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(TbRichTextView tbRichTextView) {
        this.aOG = tbRichTextView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.aOG.aOw = true;
        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            this.aOG.aOw = false;
        }
        return false;
    }
}
