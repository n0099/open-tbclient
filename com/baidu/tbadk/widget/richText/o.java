package com.baidu.tbadk.widget.richText;

import android.view.View;
/* loaded from: classes.dex */
class o implements View.OnClickListener {
    final /* synthetic */ TbRichTextView akM;
    private final /* synthetic */ c akN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(TbRichTextView tbRichTextView, c cVar) {
        this.akM = tbRichTextView;
        this.akN = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((this.akM.getContext() instanceof j) && this.akN.Al() != null) {
            ((j) this.akM.getContext()).onVideoClicked(this.akM.getContext(), this.akN.Al().toString());
        }
    }
}
