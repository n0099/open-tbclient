package com.baidu.tbadk.widget.richText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements Runnable {
    final /* synthetic */ TbRichTextView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(TbRichTextView tbRichTextView) {
        this.a = tbRichTextView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.a.performLongClick()) {
            this.a.z = true;
        }
    }
}
