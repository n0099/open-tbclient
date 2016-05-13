package com.baidu.tbadk.widget.richText;

import android.view.View;
import com.baidu.tbadk.widget.richText.TbRichTextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ TbRichTextView aFD;
    private final /* synthetic */ c aFE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(TbRichTextView tbRichTextView, c cVar) {
        this.aFD = tbRichTextView;
        this.aFE = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbRichTextView.c cVar;
        TbRichTextView.c cVar2;
        cVar = this.aFD.aFm;
        if (cVar != null) {
            d GO = this.aFE.GO();
            cVar2 = this.aFD.aFm;
            cVar2.a(view, GO.aty.mGid, GO.aty.mPackageName, GO.aty.NM, GO.aty.ata, GO.aty.atb, GO.aty.asZ, GO.aty.atc, GO.aty.atd);
        }
    }
}
