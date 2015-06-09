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
            e Ev = this.auY.Ev();
            rVar2 = this.auX.auQ;
            rVar2.a(view, Ev.alT.alw, Ev.alT.mPackageName, Ev.alT.alz, Ev.alT.alu, Ev.alT.alv, Ev.alT.alt, Ev.alT.alx, Ev.alT.aly);
        }
    }
}
