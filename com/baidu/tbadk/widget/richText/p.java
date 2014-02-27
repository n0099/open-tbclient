package com.baidu.tbadk.widget.richText;
/* loaded from: classes.dex */
final class p implements Runnable {
    final /* synthetic */ TbRichTextView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(TbRichTextView tbRichTextView) {
        this.a = tbRichTextView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.a.performLongClick()) {
            this.a.z = true;
        }
    }
}
