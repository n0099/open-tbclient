package com.baidu.tieba.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class ad implements View.OnClickListener {
    private final /* synthetic */ int BF;
    final /* synthetic */ ab ait;
    private final /* synthetic */ af aiu;
    private final /* synthetic */ ImageFileInfo aiv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ab abVar, af afVar, int i, ImageFileInfo imageFileInfo) {
        this.ait = abVar;
        this.aiu = afVar;
        this.BF = i;
        this.aiv = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        z zVar;
        z zVar2;
        zVar = this.ait.air;
        if (zVar != null && this.aiu.aiy) {
            zVar2 = this.ait.air;
            zVar2.onClick(this.BF, this.aiv);
        }
    }
}
