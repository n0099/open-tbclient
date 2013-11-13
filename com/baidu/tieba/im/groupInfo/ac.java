package com.baidu.tieba.im.groupInfo;

import android.view.View;
import com.baidu.tieba.im.data.PhotoUrlData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PhotoUrlData f1682a;
    final /* synthetic */ int b;
    final /* synthetic */ PhotoWallView c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(PhotoWallView photoWallView, PhotoUrlData photoUrlData, int i) {
        this.c = photoWallView;
        this.f1682a = photoUrlData;
        this.b = i;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        aa aaVar;
        aa aaVar2;
        aaVar = this.c.m;
        if (aaVar != null) {
            aaVar2 = this.c.m;
            aaVar2.a(view, this.f1682a, this.b);
            return true;
        }
        return true;
    }
}
