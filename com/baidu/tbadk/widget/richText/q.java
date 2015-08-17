package com.baidu.tbadk.widget.richText;

import android.view.View;
import com.baidu.tbadk.widget.richText.TbRichTextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ TbRichTextView aCn;
    private final /* synthetic */ c aCp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(TbRichTextView tbRichTextView, c cVar) {
        this.aCn = tbRichTextView;
        this.aCp = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbRichTextView.b bVar;
        TbRichTextView.b bVar2;
        bVar = this.aCn.aCf;
        if (bVar != null) {
            d Fg = this.aCp.Fg();
            bVar2 = this.aCn.aCf;
            bVar2.a(view, Fg.atx.mGid, Fg.atx.mPackageName, Fg.atx.atd, Fg.atx.asZ, Fg.atx.ata, Fg.atx.asY, Fg.atx.atb, Fg.atx.atc);
        }
    }
}
