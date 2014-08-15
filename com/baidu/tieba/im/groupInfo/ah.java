package com.baidu.tieba.im.groupInfo;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements View.OnClickListener {
    final /* synthetic */ PhotoWallView a;
    private final /* synthetic */ int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(PhotoWallView photoWallView, int i) {
        this.a = photoWallView;
        this.b = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ad adVar;
        ad adVar2;
        adVar = this.a.j;
        if (adVar != null) {
            adVar2 = this.a.j;
            adVar2.onClick(view, 2, null, this.b);
        }
    }
}
