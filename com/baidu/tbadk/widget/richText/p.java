package com.baidu.tbadk.widget.richText;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    final /* synthetic */ TbRichTextView atr;
    private final /* synthetic */ c ats;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(TbRichTextView tbRichTextView, c cVar) {
        this.atr = tbRichTextView;
        this.ats = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        r rVar;
        r rVar2;
        rVar = this.atr.atk;
        if (rVar != null) {
            e DK = this.ats.DK();
            rVar2 = this.atr.atk;
            rVar2.a(view, DK.akS.akv, DK.akS.mPackageName, DK.akS.aky, DK.akS.akt, DK.akS.aku, DK.akS.aks, DK.akS.akw, DK.akS.akx);
        }
    }
}
