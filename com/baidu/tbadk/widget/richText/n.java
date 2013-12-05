package com.baidu.tbadk.widget.richText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TbRichTextView f1000a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(TbRichTextView tbRichTextView) {
        this.f1000a = tbRichTextView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f1000a.performLongClick()) {
            this.f1000a.z = true;
        }
    }
}
