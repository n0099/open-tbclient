package com.baidu.tbadk.widget.richText;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    final /* synthetic */ TbRichTextView akJ;
    private final /* synthetic */ c akK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(TbRichTextView tbRichTextView, c cVar) {
        this.akJ = tbRichTextView;
        this.akK = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        r rVar;
        r rVar2;
        rVar = this.akJ.akD;
        if (rVar != null) {
            e Ai = this.akK.Ai();
            rVar2 = this.akJ.akD;
            rVar2.a(view, Ai.aam.ZP, Ai.aam.mPackageName, Ai.aam.ZS, Ai.aam.ZN, Ai.aam.ZO, Ai.aam.ZM, Ai.aam.ZQ, Ai.aam.ZR);
        }
    }
}
