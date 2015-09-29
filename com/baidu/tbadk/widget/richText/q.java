package com.baidu.tbadk.widget.richText;

import android.view.View;
import com.baidu.tbadk.widget.richText.TbRichTextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ TbRichTextView aCr;
    private final /* synthetic */ c aCt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(TbRichTextView tbRichTextView, c cVar) {
        this.aCr = tbRichTextView;
        this.aCt = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbRichTextView.b bVar;
        TbRichTextView.b bVar2;
        bVar = this.aCr.aCj;
        if (bVar != null) {
            d Fd = this.aCt.Fd();
            bVar2 = this.aCr.aCj;
            bVar2.a(view, Fd.atE.mGid, Fd.atE.mPackageName, Fd.atE.atk, Fd.atE.atg, Fd.atE.ath, Fd.atE.atf, Fd.atE.ati, Fd.atE.atj);
        }
    }
}
