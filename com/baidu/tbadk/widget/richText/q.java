package com.baidu.tbadk.widget.richText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements Runnable {
    final /* synthetic */ TbRichTextView auX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(TbRichTextView tbRichTextView) {
        this.auX = tbRichTextView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.auX.performLongClick()) {
            this.auX.auN = true;
        }
    }
}
