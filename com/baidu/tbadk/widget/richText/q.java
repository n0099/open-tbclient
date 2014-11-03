package com.baidu.tbadk.widget.richText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements Runnable {
    final /* synthetic */ TbRichTextView acw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(TbRichTextView tbRichTextView) {
        this.acw = tbRichTextView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.acw.performLongClick()) {
            this.acw.aco = true;
        }
    }
}
