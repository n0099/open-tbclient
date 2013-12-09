package com.baidu.tieba.im.groupInfo;

import android.view.View;
import com.baidu.tieba.im.data.PhotoUrlData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PhotoUrlData f1740a;
    final /* synthetic */ int b;
    final /* synthetic */ PhotoWallView c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(PhotoWallView photoWallView, PhotoUrlData photoUrlData, int i) {
        this.c = photoWallView;
        this.f1740a = photoUrlData;
        this.b = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        y yVar;
        y yVar2;
        yVar = this.c.k;
        if (yVar != null) {
            yVar2 = this.c.k;
            yVar2.onClick(view, 1, this.f1740a, this.b);
        }
    }
}
