package com.baidu.tbadk.widget.richText;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
class l implements View.OnTouchListener {
    final /* synthetic */ TbRichTextView aPX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(TbRichTextView tbRichTextView) {
        this.aPX = tbRichTextView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.aPX.aPK = true;
        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            this.aPX.aPK = false;
        }
        return false;
    }
}
