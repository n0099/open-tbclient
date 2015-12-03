package com.baidu.tbadk.widget.richText;

import android.view.View;
import com.baidu.tbadk.widget.richText.TbRichTextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnClickListener {
    final /* synthetic */ TbRichTextView aEi;
    private final /* synthetic */ c aEk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(TbRichTextView tbRichTextView, c cVar) {
        this.aEi = tbRichTextView;
        this.aEk = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbRichTextView.c cVar;
        TbRichTextView.c cVar2;
        cVar = this.aEi.aDZ;
        if (cVar != null) {
            d FV = this.aEk.FV();
            cVar2 = this.aEi.aDZ;
            cVar2.a(view, FV.auv.mGid, FV.auv.mPackageName, FV.auv.aua, FV.auv.atW, FV.auv.atX, FV.auv.atV, FV.auv.atY, FV.auv.atZ);
        }
    }
}
