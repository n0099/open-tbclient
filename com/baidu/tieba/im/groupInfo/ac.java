package com.baidu.tieba.im.groupInfo;

import android.view.View;
import com.baidu.tieba.im.data.PhotoUrlData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements View.OnLongClickListener {
    final /* synthetic */ PhotoWallView a;
    private final /* synthetic */ PhotoUrlData b;
    private final /* synthetic */ int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(PhotoWallView photoWallView, PhotoUrlData photoUrlData, int i) {
        this.a = photoWallView;
        this.b = photoUrlData;
        this.c = i;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        aa aaVar;
        aa aaVar2;
        aaVar = this.a.l;
        if (aaVar != null) {
            aaVar2 = this.a.l;
            aaVar2.a(view, this.b, this.c);
            return true;
        }
        return true;
    }
}
