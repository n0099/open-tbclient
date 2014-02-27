package com.baidu.tieba.guide;

import android.widget.ImageView;
/* loaded from: classes.dex */
final class r implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ o a;
    private final /* synthetic */ ImageView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(o oVar, ImageView imageView) {
        this.a = oVar;
        this.b = imageView;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        if (bVar != null) {
            bVar.a(this.b);
        }
    }
}
