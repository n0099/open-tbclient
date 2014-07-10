package com.baidu.tieba.im.groupInfo;

import android.view.View;
import com.baidu.tbadk.coreExtra.data.PhotoUrlData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements View.OnLongClickListener {
    final /* synthetic */ PhotoWallView a;
    private final /* synthetic */ PhotoUrlData b;
    private final /* synthetic */ int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(PhotoWallView photoWallView, PhotoUrlData photoUrlData, int i) {
        this.a = photoWallView;
        this.b = photoUrlData;
        this.c = i;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        ad adVar;
        ad adVar2;
        adVar = this.a.k;
        if (adVar != null) {
            adVar2 = this.a.k;
            adVar2.a(view, this.b, this.c);
            return true;
        }
        return true;
    }
}
