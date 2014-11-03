package com.baidu.tbadk.widget.richText;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    final /* synthetic */ TbRichTextView acw;
    private final /* synthetic */ c acx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(TbRichTextView tbRichTextView, c cVar) {
        this.acw = tbRichTextView;
        this.acx = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        r rVar;
        r rVar2;
        rVar = this.acw.acr;
        if (rVar != null) {
            e vJ = this.acx.vJ();
            rVar2 = this.acw.acr;
            rVar2.a(view, vJ.TJ.Tm, vJ.TJ.mPackageName, vJ.TJ.Tp, vJ.TJ.Tk, vJ.TJ.Tl, vJ.TJ.Tj, vJ.TJ.Tn, vJ.TJ.To);
        }
    }
}
