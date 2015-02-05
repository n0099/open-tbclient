package com.baidu.tbadk.widget.richText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements Runnable {
    final /* synthetic */ TbRichTextView akJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(TbRichTextView tbRichTextView) {
        this.akJ = tbRichTextView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.akJ.performLongClick()) {
            this.akJ.akA = true;
        }
    }
}
