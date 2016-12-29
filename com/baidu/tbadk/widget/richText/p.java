package com.baidu.tbadk.widget.richText;

import android.view.View;
import com.baidu.tbadk.widget.richText.TbRichTextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    final /* synthetic */ TbRichTextView aJR;
    private final /* synthetic */ c aJS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(TbRichTextView tbRichTextView, c cVar) {
        this.aJR = tbRichTextView;
        this.aJS = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbRichTextView.d dVar;
        TbRichTextView.d dVar2;
        dVar = this.aJR.aJz;
        if (dVar != null) {
            d HI = this.aJS.HI();
            dVar2 = this.aJR.aJz;
            dVar2.a(view, HI.ayb.mGid, HI.ayb.mPackageName, HI.ayb.mIcon, HI.ayb.axD, HI.ayb.axE, HI.ayb.axC, HI.ayb.axF, HI.ayb.axG);
        }
    }
}
