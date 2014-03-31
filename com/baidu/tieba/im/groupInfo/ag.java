package com.baidu.tieba.im.groupInfo;

import android.view.View;
import com.baidu.tbadk.coreExtra.data.PhotoUrlData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ag implements View.OnClickListener {
    final /* synthetic */ PhotoWallView a;
    private final /* synthetic */ PhotoUrlData b;
    private final /* synthetic */ int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(PhotoWallView photoWallView, PhotoUrlData photoUrlData, int i) {
        this.a = photoWallView;
        this.b = photoUrlData;
        this.c = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ae aeVar;
        ae aeVar2;
        aeVar = this.a.k;
        if (aeVar != null) {
            aeVar2 = this.a.k;
            aeVar2.onClick(view, 1, this.b, this.c);
        }
    }
}
