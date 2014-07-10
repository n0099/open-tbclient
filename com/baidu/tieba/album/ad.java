package com.baidu.tieba.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class ad implements View.OnClickListener {
    final /* synthetic */ ab a;
    private final /* synthetic */ af b;
    private final /* synthetic */ int c;
    private final /* synthetic */ ImageFileInfo d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ab abVar, af afVar, int i, ImageFileInfo imageFileInfo) {
        this.a = abVar;
        this.b = afVar;
        this.c = i;
        this.d = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        z zVar;
        z zVar2;
        zVar = this.a.e;
        if (zVar != null && this.b.a) {
            zVar2 = this.a.e;
            zVar2.onClick(this.c, this.d);
        }
    }
}
