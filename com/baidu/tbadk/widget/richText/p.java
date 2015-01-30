package com.baidu.tbadk.widget.richText;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    final /* synthetic */ TbRichTextView akM;
    private final /* synthetic */ c akN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(TbRichTextView tbRichTextView, c cVar) {
        this.akM = tbRichTextView;
        this.akN = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        r rVar;
        r rVar2;
        rVar = this.akM.akG;
        if (rVar != null) {
            e Ao = this.akN.Ao();
            rVar2 = this.akM.akG;
            rVar2.a(view, Ao.aap.ZS, Ao.aap.mPackageName, Ao.aap.ZV, Ao.aap.ZQ, Ao.aap.ZR, Ao.aap.ZP, Ao.aap.ZT, Ao.aap.ZU);
        }
    }
}
