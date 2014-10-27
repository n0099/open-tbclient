package com.baidu.tieba.im.groupInfo;

import android.view.View;
import com.baidu.tbadk.coreExtra.data.PhotoUrlData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements View.OnLongClickListener {
    private final /* synthetic */ int BF;
    final /* synthetic */ PhotoWallView bbK;
    private final /* synthetic */ PhotoUrlData bbL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(PhotoWallView photoWallView, PhotoUrlData photoUrlData, int i) {
        this.bbK = photoWallView;
        this.bbL = photoUrlData;
        this.BF = i;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        af afVar;
        af afVar2;
        afVar = this.bbK.bbI;
        if (afVar != null) {
            afVar2 = this.bbK.bbI;
            afVar2.a(view, this.bbL, this.BF);
            return true;
        }
        return true;
    }
}
