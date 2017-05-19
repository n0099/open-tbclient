package com.baidu.tbadk.widget.richText;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ TbRichTextView aOG;
    private final /* synthetic */ TbRichTextData aOH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(TbRichTextView tbRichTextView, TbRichTextData tbRichTextData) {
        this.aOG = tbRichTextView;
        this.aOH = tbRichTextData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aOH.HJ() != null) {
            if (this.aOG.getContext() instanceof d) {
                ((d) this.aOG.getContext()).aa(this.aOG.getContext(), this.aOH.HJ().toString());
                return;
            }
            com.baidu.adp.base.g<?> Z = com.baidu.adp.base.k.Z(this.aOG.getContext());
            if (Z != null && (Z.getOrignalPage() instanceof d)) {
                ((d) Z.getOrignalPage()).aa(this.aOG.getContext(), this.aOH.HJ().toString());
            }
        }
    }
}
