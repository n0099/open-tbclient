package com.baidu.tieba.im.groupInfo;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements View.OnClickListener {
    final /* synthetic */ int a;
    final /* synthetic */ PhotoWallView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(PhotoWallView photoWallView, int i) {
        this.b = photoWallView;
        this.a = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        y yVar;
        y yVar2;
        yVar = this.b.k;
        if (yVar != null) {
            yVar2 = this.b.k;
            yVar2.onClick(view, 2, null, this.a);
        }
    }
}
