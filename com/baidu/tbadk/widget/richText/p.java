package com.baidu.tbadk.widget.richText;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    final /* synthetic */ TbRichTextView aki;
    private final /* synthetic */ c akj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(TbRichTextView tbRichTextView, c cVar) {
        this.aki = tbRichTextView;
        this.akj = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        r rVar;
        r rVar2;
        rVar = this.aki.akd;
        if (rVar != null) {
            e zU = this.akj.zU();
            rVar2 = this.aki.akd;
            rVar2.a(view, zU.ZO.Zr, zU.ZO.mPackageName, zU.ZO.Zu, zU.ZO.Zp, zU.ZO.Zq, zU.ZO.Zo, zU.ZO.Zs, zU.ZO.Zt);
        }
    }
}
