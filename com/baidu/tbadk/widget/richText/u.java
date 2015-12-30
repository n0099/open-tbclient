package com.baidu.tbadk.widget.richText;

import android.view.View;
import com.baidu.tbadk.widget.richText.TbRichTextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnClickListener {
    final /* synthetic */ TbRichTextView aFI;
    private final /* synthetic */ c aFK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(TbRichTextView tbRichTextView, c cVar) {
        this.aFI = tbRichTextView;
        this.aFK = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbRichTextView.c cVar;
        TbRichTextView.c cVar2;
        cVar = this.aFI.aFy;
        if (cVar != null) {
            d FK = this.aFK.FK();
            cVar2 = this.aFI.aFy;
            cVar2.a(view, FK.avZ.mGid, FK.avZ.mPackageName, FK.avZ.avE, FK.avZ.avA, FK.avZ.avB, FK.avZ.avz, FK.avZ.avC, FK.avZ.avD);
        }
    }
}
