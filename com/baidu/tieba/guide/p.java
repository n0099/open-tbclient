package com.baidu.tieba.guide;

import android.widget.ImageView;
/* loaded from: classes.dex */
class p implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ m a;
    private final /* synthetic */ ImageView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(m mVar, ImageView imageView) {
        this.a = mVar;
        this.b = imageView;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        if (aVar != null) {
            aVar.a(this.b);
        }
    }
}
