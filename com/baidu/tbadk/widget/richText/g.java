package com.baidu.tbadk.widget.richText;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ TbRichTextView aOF;
    private final /* synthetic */ TbRichTextData aOG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(TbRichTextView tbRichTextView, TbRichTextData tbRichTextData) {
        this.aOF = tbRichTextView;
        this.aOG = tbRichTextData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aOG.HE() != null) {
            if (this.aOF.getContext() instanceof d) {
                ((d) this.aOF.getContext()).aa(this.aOF.getContext(), this.aOG.HE().toString());
                return;
            }
            com.baidu.adp.base.g<?> Z = com.baidu.adp.base.k.Z(this.aOF.getContext());
            if (Z != null && (Z.getOrignalPage() instanceof d)) {
                ((d) Z.getOrignalPage()).aa(this.aOF.getContext(), this.aOG.HE().toString());
            }
        }
    }
}
