package com.baidu.tbadk.widget.richText;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    final /* synthetic */ TbRichTextView atj;
    private final /* synthetic */ c atk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(TbRichTextView tbRichTextView, c cVar) {
        this.atj = tbRichTextView;
        this.atk = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        r rVar;
        r rVar2;
        rVar = this.atj.atc;
        if (rVar != null) {
            e DE = this.atk.DE();
            rVar2 = this.atj.atc;
            rVar2.a(view, DE.akK.akn, DE.akK.mPackageName, DE.akK.akq, DE.akK.akl, DE.akK.akm, DE.akK.akk, DE.akK.ako, DE.akK.akp);
        }
    }
}
