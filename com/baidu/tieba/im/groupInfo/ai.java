package com.baidu.tieba.im.groupInfo;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ai implements View.OnClickListener {
    final /* synthetic */ PhotoWallView a;
    private final /* synthetic */ int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(PhotoWallView photoWallView, int i) {
        this.a = photoWallView;
        this.b = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ae aeVar;
        ae aeVar2;
        aeVar = this.a.k;
        if (aeVar != null) {
            aeVar2 = this.a.k;
            aeVar2.onClick(view, 2, null, this.b);
        }
    }
}
