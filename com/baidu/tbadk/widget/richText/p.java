package com.baidu.tbadk.widget.richText;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    final /* synthetic */ TbRichTextView acr;
    private final /* synthetic */ c acs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(TbRichTextView tbRichTextView, c cVar) {
        this.acr = tbRichTextView;
        this.acs = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        r rVar;
        r rVar2;
        rVar = this.acr.acm;
        if (rVar != null) {
            e vH = this.acs.vH();
            rVar2 = this.acr.acm;
            rVar2.a(view, vH.TF.Ti, vH.TF.mPackageName, vH.TF.Tl, vH.TF.Tg, vH.TF.Th, vH.TF.Tf, vH.TF.Tj, vH.TF.Tk);
        }
    }
}
