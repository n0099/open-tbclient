package com.baidu.tbadk.widget.richText;

import android.view.View;
import com.baidu.tbadk.widget.richText.TbRichTextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ TbRichTextView aJH;
    private final /* synthetic */ c aJI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(TbRichTextView tbRichTextView, c cVar) {
        this.aJH = tbRichTextView;
        this.aJI = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbRichTextView.d dVar;
        TbRichTextView.d dVar2;
        dVar = this.aJH.aJp;
        if (dVar != null) {
            d Ij = this.aJI.Ij();
            dVar2 = this.aJH.aJp;
            dVar2.a(view, Ij.axN.mGid, Ij.axN.mPackageName, Ij.axN.mIcon, Ij.axN.axp, Ij.axN.axq, Ij.axN.axo, Ij.axN.axr, Ij.axN.axs);
        }
    }
}
