package com.baidu.tbadk.widget.richText;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
class i implements View.OnTouchListener {
    final /* synthetic */ TbRichTextView aNV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(TbRichTextView tbRichTextView) {
        this.aNV = tbRichTextView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.aNV.aNL = true;
        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            this.aNV.aNL = false;
        }
        return false;
    }
}
