package com.baidu.tieba.im.groupInfo;

import android.view.View;
import com.baidu.tieba.im.data.PhotoUrlData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements View.OnClickListener {
    final /* synthetic */ PhotoWallView a;
    private final /* synthetic */ PhotoUrlData b;
    private final /* synthetic */ int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(PhotoWallView photoWallView, PhotoUrlData photoUrlData, int i) {
        this.a = photoWallView;
        this.b = photoUrlData;
        this.c = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        z zVar;
        z zVar2;
        zVar = this.a.k;
        if (zVar != null) {
            zVar2 = this.a.k;
            zVar2.onClick(view, 1, this.b, this.c);
        }
    }
}
