package com.baidu.tbadk.widget.richText;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f992a;
    final /* synthetic */ TbRichTextView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(TbRichTextView tbRichTextView, c cVar) {
        this.b = tbRichTextView;
        this.f992a = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((this.b.getContext() instanceof i) && this.f992a.d() != null) {
            ((i) this.b.getContext()).c(this.b.getContext(), this.f992a.d().toString());
        }
    }
}
