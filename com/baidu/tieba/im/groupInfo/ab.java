package com.baidu.tieba.im.groupInfo;

import android.view.View;
import com.baidu.tieba.im.data.PhotoUrlData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PhotoUrlData f1741a;
    final /* synthetic */ int b;
    final /* synthetic */ PhotoWallView c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(PhotoWallView photoWallView, PhotoUrlData photoUrlData, int i) {
        this.c = photoWallView;
        this.f1741a = photoUrlData;
        this.b = i;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        z zVar;
        z zVar2;
        zVar = this.c.l;
        if (zVar != null) {
            zVar2 = this.c.l;
            zVar2.a(view, this.f1741a, this.b);
            return true;
        }
        return true;
    }
}
