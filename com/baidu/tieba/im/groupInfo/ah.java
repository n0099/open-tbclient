package com.baidu.tieba.im.groupInfo;

import android.view.View;
import com.baidu.tbadk.coreExtra.data.PhotoUrlData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements View.OnClickListener {
    private final /* synthetic */ int BG;
    final /* synthetic */ PhotoWallView bbY;
    private final /* synthetic */ PhotoUrlData bbZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(PhotoWallView photoWallView, PhotoUrlData photoUrlData, int i) {
        this.bbY = photoWallView;
        this.bbZ = photoUrlData;
        this.BG = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        af afVar;
        af afVar2;
        afVar = this.bbY.bbV;
        if (afVar != null) {
            afVar2 = this.bbY.bbV;
            afVar2.onClick(view, 1, this.bbZ, this.BG);
        }
    }
}
