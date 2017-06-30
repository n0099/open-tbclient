package com.baidu.tbadk.widget.richText;

import android.view.MotionEvent;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
class m implements TbImageView.b {
    final /* synthetic */ TbRichTextView aPX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(TbRichTextView tbRichTextView) {
        this.aPX = tbRichTextView;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.b
    public void n(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.aPX.aPQ = true;
        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            this.aPX.aPQ = false;
        }
    }
}
