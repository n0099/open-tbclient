package com.baidu.tbadk.widget.richText;

import android.view.View;
import com.baidu.tbadk.widget.richText.TbRichTextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ TbRichTextView aGf;
    private final /* synthetic */ c aGg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(TbRichTextView tbRichTextView, c cVar) {
        this.aGf = tbRichTextView;
        this.aGg = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbRichTextView.c cVar;
        TbRichTextView.c cVar2;
        cVar = this.aGf.aFN;
        if (cVar != null) {
            d GP = this.aGg.GP();
            cVar2 = this.aGf.aFN;
            cVar2.a(view, GP.auo.mGid, GP.auo.mPackageName, GP.auo.mIcon, GP.auo.atQ, GP.auo.atR, GP.auo.atP, GP.auo.atS, GP.auo.atT);
        }
    }
}
