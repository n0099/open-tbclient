package com.baidu.tieba.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class ac implements View.OnClickListener {
    private final /* synthetic */ int FV;
    final /* synthetic */ aa aqQ;
    private final /* synthetic */ af aqR;
    private final /* synthetic */ ImageFileInfo aqS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(aa aaVar, af afVar, int i, ImageFileInfo imageFileInfo) {
        this.aqQ = aaVar;
        this.aqR = afVar;
        this.FV = i;
        this.aqS = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        y yVar;
        y yVar2;
        yVar = this.aqQ.aqN;
        if (yVar != null && this.aqR.aqV) {
            yVar2 = this.aqQ.aqN;
            yVar2.onClick(this.FV, this.aqS);
        }
    }
}
