package com.baidu.tbadk.widget.richText;

import android.view.View;
import com.baidu.tbadk.widget.richText.TbRichTextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ TbRichTextView aCC;
    private final /* synthetic */ c aCE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(TbRichTextView tbRichTextView, c cVar) {
        this.aCC = tbRichTextView;
        this.aCE = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbRichTextView.b bVar;
        TbRichTextView.b bVar2;
        bVar = this.aCC.aCu;
        if (bVar != null) {
            d Fd = this.aCE.Fd();
            bVar2 = this.aCC.aCu;
            bVar2.a(view, Fd.atF.mGid, Fd.atF.mPackageName, Fd.atF.atl, Fd.atF.ath, Fd.atF.ati, Fd.atF.atg, Fd.atF.atj, Fd.atF.atk);
        }
    }
}
