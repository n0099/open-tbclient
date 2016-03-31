package com.baidu.tbadk.widget.richText;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements View.OnClickListener {
    final /* synthetic */ TbRichTextView aJw;
    private final /* synthetic */ c aJy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(TbRichTextView tbRichTextView, c cVar) {
        this.aJw = tbRichTextView;
        this.aJy = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aJy.Is() != null) {
            if (this.aJw.getContext() instanceof m) {
                ((m) this.aJw.getContext()).A(this.aJw.getContext(), this.aJy.Is().toString());
                return;
            }
            com.baidu.adp.base.h<?> s = com.baidu.adp.base.l.s(this.aJw.getContext());
            if (s != null && (s.getOrignalPage() instanceof m)) {
                ((m) s.getOrignalPage()).A(this.aJw.getContext(), this.aJy.Is().toString());
            }
        }
    }
}
