package com.baidu.tbadk.widget.richText;

import android.view.View;
import com.baidu.tbadk.widget.richText.TbRichTextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ TbRichTextView aKA;
    private final /* synthetic */ c aKB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(TbRichTextView tbRichTextView, c cVar) {
        this.aKA = tbRichTextView;
        this.aKB = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbRichTextView.d dVar;
        TbRichTextView.d dVar2;
        dVar = this.aKA.aKi;
        if (dVar != null) {
            d Im = this.aKB.Im();
            dVar2 = this.aKA.aKi;
            dVar2.a(view, Im.ayE.mGid, Im.ayE.mPackageName, Im.ayE.mIcon, Im.ayE.ayg, Im.ayE.ayh, Im.ayE.ayf, Im.ayE.ayi, Im.ayE.ayj);
        }
    }
}
