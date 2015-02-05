package com.baidu.tieba.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class ac implements View.OnClickListener {
    private final /* synthetic */ int FS;
    final /* synthetic */ aa aqN;
    private final /* synthetic */ af aqO;
    private final /* synthetic */ ImageFileInfo aqP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(aa aaVar, af afVar, int i, ImageFileInfo imageFileInfo) {
        this.aqN = aaVar;
        this.aqO = afVar;
        this.FS = i;
        this.aqP = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        y yVar;
        y yVar2;
        yVar = this.aqN.aqK;
        if (yVar != null && this.aqO.aqS) {
            yVar2 = this.aqN.aqK;
            yVar2.onClick(this.FS, this.aqP);
        }
    }
}
