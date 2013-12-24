package com.baidu.tbadk.widget.richText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements Runnable {
    final /* synthetic */ TbRichTextView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(TbRichTextView tbRichTextView) {
        this.a = tbRichTextView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.a.performLongClick()) {
            this.a.z = true;
        }
    }
}
