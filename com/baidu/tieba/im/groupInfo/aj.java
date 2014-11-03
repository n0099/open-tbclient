package com.baidu.tieba.im.groupInfo;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements View.OnClickListener {
    private final /* synthetic */ int BG;
    final /* synthetic */ PhotoWallView bbY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(PhotoWallView photoWallView, int i) {
        this.bbY = photoWallView;
        this.BG = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        af afVar;
        af afVar2;
        afVar = this.bbY.bbV;
        if (afVar != null) {
            afVar2 = this.bbY.bbV;
            afVar2.onClick(view, 2, null, this.BG);
        }
    }
}
