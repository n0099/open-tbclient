package com.baidu.tieba.im.groupInfo;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements View.OnClickListener {
    final /* synthetic */ PhotoWallView a;
    private final /* synthetic */ int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(PhotoWallView photoWallView, int i) {
        this.a = photoWallView;
        this.b = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ac acVar;
        ac acVar2;
        acVar = this.a.j;
        if (acVar != null) {
            acVar2 = this.a.j;
            acVar2.onClick(view, 2, null, this.b);
        }
    }
}
