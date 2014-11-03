package com.baidu.tieba.im.groupInfo;

import android.view.View;
import com.baidu.tbadk.coreExtra.data.PhotoUrlData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements View.OnLongClickListener {
    private final /* synthetic */ int BG;
    final /* synthetic */ PhotoWallView bbY;
    private final /* synthetic */ PhotoUrlData bbZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(PhotoWallView photoWallView, PhotoUrlData photoUrlData, int i) {
        this.bbY = photoWallView;
        this.bbZ = photoUrlData;
        this.BG = i;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        ag agVar;
        ag agVar2;
        agVar = this.bbY.bbW;
        if (agVar != null) {
            agVar2 = this.bbY.bbW;
            agVar2.a(view, this.bbZ, this.BG);
            return true;
        }
        return true;
    }
}
