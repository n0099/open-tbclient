package com.baidu.tieba.im.groupInfo;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements View.OnClickListener {
    private final /* synthetic */ int BF;
    final /* synthetic */ PhotoWallView bbK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(PhotoWallView photoWallView, int i) {
        this.bbK = photoWallView;
        this.BF = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ae aeVar;
        ae aeVar2;
        aeVar = this.bbK.bbH;
        if (aeVar != null) {
            aeVar2 = this.bbK.bbH;
            aeVar2.onClick(view, 2, null, this.BF);
        }
    }
}
