package com.baidu.tbadk.widget.richText;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ TbRichTextView aOl;
    private final /* synthetic */ TbRichTextData aOm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(TbRichTextView tbRichTextView, TbRichTextData tbRichTextData) {
        this.aOl = tbRichTextView;
        this.aOm = tbRichTextData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aOm.Iv() != null) {
            if (this.aOl.getContext() instanceof d) {
                ((d) this.aOl.getContext()).aa(this.aOl.getContext(), this.aOm.Iv().toString());
                return;
            }
            com.baidu.adp.base.g<?> Z = com.baidu.adp.base.k.Z(this.aOl.getContext());
            if (Z != null && (Z.getOrignalPage() instanceof d)) {
                ((d) Z.getOrignalPage()).aa(this.aOl.getContext(), this.aOm.Iv().toString());
            }
        }
    }
}
