package com.baidu.tieba.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class ad implements View.OnClickListener {
    private final /* synthetic */ int FS;
    final /* synthetic */ aa aqN;
    private final /* synthetic */ ImageFileInfo aqP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(aa aaVar, int i, ImageFileInfo imageFileInfo) {
        this.aqN = aaVar;
        this.FS = i;
        this.aqP = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        x xVar;
        x xVar2;
        xVar = this.aqN.aqL;
        if (xVar != null) {
            xVar2 = this.aqN.aqL;
            xVar2.onClick(this.FS, this.aqP);
        }
    }
}
