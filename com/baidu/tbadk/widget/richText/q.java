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
            d EZ = this.aCE.EZ();
            bVar2 = this.aCC.aCu;
            bVar2.a(view, EZ.atF.mGid, EZ.atF.mPackageName, EZ.atF.atl, EZ.atF.ath, EZ.atF.ati, EZ.atF.atg, EZ.atF.atj, EZ.atF.atk);
        }
    }
}
