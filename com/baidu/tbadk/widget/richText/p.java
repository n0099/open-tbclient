package com.baidu.tbadk.widget.richText;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    final /* synthetic */ TbRichTextView auX;
    private final /* synthetic */ c auY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(TbRichTextView tbRichTextView, c cVar) {
        this.auX = tbRichTextView;
        this.auY = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        r rVar;
        r rVar2;
        rVar = this.auX.auQ;
        if (rVar != null) {
            e Eu = this.auY.Eu();
            rVar2 = this.auX.auQ;
            rVar2.a(view, Eu.alT.alw, Eu.alT.mPackageName, Eu.alT.alz, Eu.alT.alu, Eu.alT.alv, Eu.alT.alt, Eu.alT.alx, Eu.alT.aly);
        }
    }
}
