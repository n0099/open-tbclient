package com.baidu.tbadk.widget.richText;

import android.view.View;
import com.baidu.tbadk.widget.richText.TbRichTextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements View.OnClickListener {
    final /* synthetic */ TbRichTextView aJw;
    private final /* synthetic */ c aJy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(TbRichTextView tbRichTextView, c cVar) {
        this.aJw = tbRichTextView;
        this.aJy = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbRichTextView.c cVar;
        TbRichTextView.c cVar2;
        cVar = this.aJw.aJk;
        if (cVar != null) {
            d Iw = this.aJy.Iw();
            cVar2 = this.aJw.aJk;
            cVar2.a(view, Iw.axx.mGid, Iw.axx.mPackageName, Iw.axx.Ta, Iw.axx.awZ, Iw.axx.axa, Iw.axx.awY, Iw.axx.axb, Iw.axx.axc);
        }
    }
}
