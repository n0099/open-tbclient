package com.baidu.tbadk.widget.richText;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ TbRichTextView acr;
    private final /* synthetic */ c acs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(TbRichTextView tbRichTextView, c cVar) {
        this.acr = tbRichTextView;
        this.acs = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((this.acr.getContext() instanceof j) && this.acs.vE() != null) {
            ((j) this.acr.getContext()).u(this.acr.getContext(), this.acs.vE().toString());
        }
    }
}
