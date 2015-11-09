package com.baidu.tbadk.widget.richText;

import android.view.View;
import com.baidu.tbadk.widget.richText.TbRichTextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnClickListener {
    final /* synthetic */ TbRichTextView aBw;
    private final /* synthetic */ c aBy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(TbRichTextView tbRichTextView, c cVar) {
        this.aBw = tbRichTextView;
        this.aBy = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbRichTextView.c cVar;
        TbRichTextView.c cVar2;
        cVar = this.aBw.aBn;
        if (cVar != null) {
            d ES = this.aBy.ES();
            cVar2 = this.aBw.aBn;
            cVar2.a(view, ES.ast.mGid, ES.ast.mPackageName, ES.ast.arZ, ES.ast.arV, ES.ast.arW, ES.ast.arU, ES.ast.arX, ES.ast.arY);
        }
    }
}
