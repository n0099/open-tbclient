package com.baidu.tieba.im.groupInfo;

import android.view.View;
import com.baidu.tbadk.coreExtra.data.PhotoUrlData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements View.OnClickListener {
    final /* synthetic */ PhotoWallView a;
    private final /* synthetic */ PhotoUrlData b;
    private final /* synthetic */ int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(PhotoWallView photoWallView, PhotoUrlData photoUrlData, int i) {
        this.a = photoWallView;
        this.b = photoUrlData;
        this.c = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ac acVar;
        ac acVar2;
        acVar = this.a.j;
        if (acVar != null) {
            acVar2 = this.a.j;
            acVar2.onClick(view, 1, this.b, this.c);
        }
    }
}
