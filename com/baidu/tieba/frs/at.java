package com.baidu.tieba.frs;

import android.widget.ImageView;
/* loaded from: classes.dex */
final class at implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        cm cmVar;
        cm cmVar2;
        if (bVar != null) {
            cmVar = this.a.r;
            ImageView imageView = (ImageView) cmVar.I().findViewWithTag(str);
            while (imageView != null) {
                imageView.setTag(null);
                imageView.setImageBitmap(bVar.h());
                cmVar2 = this.a.r;
                imageView = (ImageView) cmVar2.I().findViewWithTag(str);
            }
        }
    }
}
