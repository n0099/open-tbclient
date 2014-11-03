package com.baidu.tieba.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class ad implements View.OnClickListener {
    private final /* synthetic */ int BG;
    final /* synthetic */ ab aiC;
    private final /* synthetic */ af aiD;
    private final /* synthetic */ ImageFileInfo aiE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ab abVar, af afVar, int i, ImageFileInfo imageFileInfo) {
        this.aiC = abVar;
        this.aiD = afVar;
        this.BG = i;
        this.aiE = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        z zVar;
        z zVar2;
        zVar = this.aiC.aiA;
        if (zVar != null && this.aiD.aiH) {
            zVar2 = this.aiC.aiA;
            zVar2.onClick(this.BG, this.aiE);
        }
    }
}
