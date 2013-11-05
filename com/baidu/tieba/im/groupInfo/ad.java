package com.baidu.tieba.im.groupInfo;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f1596a;
    final /* synthetic */ PhotoWallView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(PhotoWallView photoWallView, int i) {
        this.b = photoWallView;
        this.f1596a = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        z zVar;
        z zVar2;
        zVar = this.b.l;
        if (zVar != null) {
            zVar2 = this.b.l;
            zVar2.onClick(view, 2, null, this.f1596a);
        }
    }
}
