package com.baidu.tbadk.widget.richText;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TbRichTextView f815a;
    private final /* synthetic */ c b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(TbRichTextView tbRichTextView, c cVar) {
        this.f815a = tbRichTextView;
        this.b = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((this.f815a.getContext() instanceof h) && this.b.d() != null) {
            ((h) this.f815a.getContext()).c(this.f815a.getContext(), this.b.d().toString());
        }
    }
}
