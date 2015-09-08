package com.baidu.tbadk.widget.richText;

import android.view.View;
import com.baidu.tbadk.widget.richText.TbRichTextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ TbRichTextView aDV;
    private final /* synthetic */ c aDX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(TbRichTextView tbRichTextView, c cVar) {
        this.aDV = tbRichTextView;
        this.aDX = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbRichTextView.b bVar;
        TbRichTextView.b bVar2;
        bVar = this.aDV.aDN;
        if (bVar != null) {
            d Fq = this.aDX.Fq();
            bVar2 = this.aDV.aDN;
            bVar2.a(view, Fq.avh.mGid, Fq.avh.mPackageName, Fq.avh.auN, Fq.avh.auJ, Fq.avh.auK, Fq.avh.auI, Fq.avh.auL, Fq.avh.auM);
        }
    }
}
