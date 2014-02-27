package com.baidu.tieba.im.groupInfo;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ad implements View.OnClickListener {
    final /* synthetic */ PhotoWallView a;
    private final /* synthetic */ int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(PhotoWallView photoWallView, int i) {
        this.a = photoWallView;
        this.b = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        z zVar;
        z zVar2;
        zVar = this.a.k;
        if (zVar != null) {
            zVar2 = this.a.k;
            zVar2.onClick(view, 2, null, this.b);
        }
    }
}
