package com.baidu.tbadk.widget.richText;

import android.view.View;
/* loaded from: classes.dex */
class l implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f977a;
    final /* synthetic */ TbRichTextView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(TbRichTextView tbRichTextView, c cVar) {
        this.b = tbRichTextView;
        this.f977a = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((this.b.getContext() instanceof h) && this.f977a.d() != null) {
            ((h) this.b.getContext()).c(this.b.getContext(), this.f977a.d().toString());
        }
    }
}
