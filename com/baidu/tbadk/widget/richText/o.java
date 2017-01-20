package com.baidu.tbadk.widget.richText;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ TbRichTextView aIy;
    private final /* synthetic */ TbRichTextData aIz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(TbRichTextView tbRichTextView, TbRichTextData tbRichTextData) {
        this.aIy = tbRichTextView;
        this.aIz = tbRichTextData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aIz.Hw() != null) {
            if (this.aIy.getContext() instanceof d) {
                ((d) this.aIy.getContext()).C(this.aIy.getContext(), this.aIz.Hw().toString());
                return;
            }
            com.baidu.adp.base.g<?> C = com.baidu.adp.base.k.C(this.aIy.getContext());
            if (C != null && (C.getOrignalPage() instanceof d)) {
                ((d) C.getOrignalPage()).C(this.aIy.getContext(), this.aIz.Hw().toString());
            }
        }
    }
}
