package com.baidu.tbadk.widget.richText;

import android.view.View;
import com.baidu.tbadk.widget.richText.TbRichTextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ TbRichTextView aGW;
    private final /* synthetic */ c aGX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(TbRichTextView tbRichTextView, c cVar) {
        this.aGW = tbRichTextView;
        this.aGX = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbRichTextView.c cVar;
        TbRichTextView.c cVar2;
        cVar = this.aGW.aGE;
        if (cVar != null) {
            d GN = this.aGX.GN();
            cVar2 = this.aGW.aGE;
            cVar2.a(view, GN.avd.mGid, GN.avd.mPackageName, GN.avd.mIcon, GN.avd.auF, GN.avd.auG, GN.avd.auE, GN.avd.auH, GN.avd.auI);
        }
    }
}
