package com.baidu.tbadk.widget.richText;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
class s implements View.OnTouchListener {
    final /* synthetic */ TbRichTextView aGf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(TbRichTextView tbRichTextView) {
        this.aGf = tbRichTextView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.aGf.aFV = true;
        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            this.aGf.aFV = false;
        }
        return false;
    }
}
