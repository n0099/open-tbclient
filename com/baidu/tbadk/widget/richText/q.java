package com.baidu.tbadk.widget.richText;

import android.view.View;
import com.baidu.tbadk.widget.richText.TbRichTextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ TbRichTextView aKi;
    private final /* synthetic */ c aKj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(TbRichTextView tbRichTextView, c cVar) {
        this.aKi = tbRichTextView;
        this.aKj = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbRichTextView.c cVar;
        TbRichTextView.c cVar2;
        cVar = this.aKi.aJQ;
        if (cVar != null) {
            d Ik = this.aKj.Ik();
            cVar2 = this.aKi.aJQ;
            cVar2.a(view, Ik.ayk.mGid, Ik.ayk.mPackageName, Ik.ayk.mIcon, Ik.ayk.axM, Ik.ayk.axN, Ik.ayk.axL, Ik.ayk.axO, Ik.ayk.axP);
        }
    }
}
