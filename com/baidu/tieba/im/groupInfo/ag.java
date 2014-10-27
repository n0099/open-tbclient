package com.baidu.tieba.im.groupInfo;

import android.view.View;
import com.baidu.tbadk.coreExtra.data.PhotoUrlData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements View.OnClickListener {
    private final /* synthetic */ int BF;
    final /* synthetic */ PhotoWallView bbK;
    private final /* synthetic */ PhotoUrlData bbL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(PhotoWallView photoWallView, PhotoUrlData photoUrlData, int i) {
        this.bbK = photoWallView;
        this.bbL = photoUrlData;
        this.BF = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ae aeVar;
        ae aeVar2;
        aeVar = this.bbK.bbH;
        if (aeVar != null) {
            aeVar2 = this.bbK.bbH;
            aeVar2.onClick(view, 1, this.bbL, this.BF);
        }
    }
}
