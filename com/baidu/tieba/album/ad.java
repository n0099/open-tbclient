package com.baidu.tieba.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class ad implements View.OnClickListener {
    private final /* synthetic */ int FV;
    final /* synthetic */ aa aqQ;
    private final /* synthetic */ ImageFileInfo aqS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(aa aaVar, int i, ImageFileInfo imageFileInfo) {
        this.aqQ = aaVar;
        this.FV = i;
        this.aqS = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        x xVar;
        x xVar2;
        xVar = this.aqQ.aqO;
        if (xVar != null) {
            xVar2 = this.aqQ.aqO;
            xVar2.onClick(this.FV, this.aqS);
        }
    }
}
