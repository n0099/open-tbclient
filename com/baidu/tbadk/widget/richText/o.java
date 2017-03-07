package com.baidu.tbadk.widget.richText;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ TbRichTextView aNV;
    private final /* synthetic */ TbRichTextData aNW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(TbRichTextView tbRichTextView, TbRichTextData tbRichTextData) {
        this.aNV = tbRichTextView;
        this.aNW = tbRichTextData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aNW.HW() != null) {
            if (this.aNV.getContext() instanceof d) {
                ((d) this.aNV.getContext()).W(this.aNV.getContext(), this.aNW.HW().toString());
                return;
            }
            com.baidu.adp.base.g<?> aa = com.baidu.adp.base.k.aa(this.aNV.getContext());
            if (aa != null && (aa.getOrignalPage() instanceof d)) {
                ((d) aa.getOrignalPage()).W(this.aNV.getContext(), this.aNW.HW().toString());
            }
        }
    }
}
