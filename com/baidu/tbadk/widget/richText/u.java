package com.baidu.tbadk.widget.richText;

import android.view.View;
import com.baidu.tbadk.widget.richText.TbRichTextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnClickListener {
    final /* synthetic */ TbRichTextView aGA;
    private final /* synthetic */ c aGC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(TbRichTextView tbRichTextView, c cVar) {
        this.aGA = tbRichTextView;
        this.aGC = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbRichTextView.c cVar;
        TbRichTextView.c cVar2;
        cVar = this.aGA.aGq;
        if (cVar != null) {
            d Hc = this.aGC.Hc();
            cVar2 = this.aGA.aGq;
            cVar2.a(view, Hc.awQ.mGid, Hc.awQ.mPackageName, Hc.awQ.Vq, Hc.awQ.aws, Hc.awQ.awt, Hc.awQ.awr, Hc.awQ.awu, Hc.awQ.awv);
        }
    }
}
