package com.baidu.tbadk.widget.richText;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
class i implements View.OnTouchListener {
    final /* synthetic */ TbRichTextView aOn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(TbRichTextView tbRichTextView) {
        this.aOn = tbRichTextView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.aOn.aOd = true;
        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            this.aOn.aOd = false;
        }
        return false;
    }
}
