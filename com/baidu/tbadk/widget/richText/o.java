package com.baidu.tbadk.widget.richText;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ TbRichTextView aOn;
    private final /* synthetic */ TbRichTextData aOo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(TbRichTextView tbRichTextView, TbRichTextData tbRichTextData) {
        this.aOn = tbRichTextView;
        this.aOo = tbRichTextData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aOo.Iv() != null) {
            if (this.aOn.getContext() instanceof d) {
                ((d) this.aOn.getContext()).aa(this.aOn.getContext(), this.aOo.Iv().toString());
                return;
            }
            com.baidu.adp.base.g<?> Z = com.baidu.adp.base.k.Z(this.aOn.getContext());
            if (Z != null && (Z.getOrignalPage() instanceof d)) {
                ((d) Z.getOrignalPage()).aa(this.aOn.getContext(), this.aOo.Iv().toString());
            }
        }
    }
}
