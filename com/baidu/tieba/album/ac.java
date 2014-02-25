package com.baidu.tieba.album;

import android.view.View;
import com.baidu.tieba.img.ImageFileInfo;
/* loaded from: classes.dex */
class ac implements View.OnClickListener {
    final /* synthetic */ aa a;
    private final /* synthetic */ ae b;
    private final /* synthetic */ int c;
    private final /* synthetic */ ImageFileInfo d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(aa aaVar, ae aeVar, int i, ImageFileInfo imageFileInfo) {
        this.a = aaVar;
        this.b = aeVar;
        this.c = i;
        this.d = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        y yVar;
        y yVar2;
        yVar = this.a.e;
        if (yVar != null && this.b.a) {
            yVar2 = this.a.e;
            yVar2.onClick(this.c, this.d);
        }
    }
}
