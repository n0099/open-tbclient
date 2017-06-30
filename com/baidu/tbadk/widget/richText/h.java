package com.baidu.tbadk.widget.richText;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    final /* synthetic */ TbRichTextView aPX;
    private final /* synthetic */ TbRichTextData aPZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(TbRichTextView tbRichTextView, TbRichTextData tbRichTextData) {
        this.aPX = tbRichTextView;
        this.aPZ = tbRichTextData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aPZ.Ib() != null) {
            if (this.aPX.getContext() instanceof d) {
                ((d) this.aPX.getContext()).ab(this.aPX.getContext(), this.aPZ.Ib().toString());
                return;
            }
            com.baidu.adp.base.g<?> Z = com.baidu.adp.base.k.Z(this.aPX.getContext());
            if (Z != null && (Z.getOrignalPage() instanceof d)) {
                ((d) Z.getOrignalPage()).ab(this.aPX.getContext(), this.aPZ.Ib().toString());
            }
        }
    }
}
