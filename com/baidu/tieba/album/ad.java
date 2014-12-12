package com.baidu.tieba.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class ad implements View.OnClickListener {
    final /* synthetic */ ab apP;
    private final /* synthetic */ af apQ;
    private final /* synthetic */ ImageFileInfo apR;
    private final /* synthetic */ int val$position;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ab abVar, af afVar, int i, ImageFileInfo imageFileInfo) {
        this.apP = abVar;
        this.apQ = afVar;
        this.val$position = i;
        this.apR = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        z zVar;
        z zVar2;
        zVar = this.apP.apN;
        if (zVar != null && this.apQ.apU) {
            zVar2 = this.apP.apN;
            zVar2.onClick(this.val$position, this.apR);
        }
    }
}
