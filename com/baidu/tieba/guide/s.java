package com.baidu.tieba.guide;

import android.widget.ImageView;
/* loaded from: classes.dex */
class s implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ p a;
    private final /* synthetic */ ImageView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(p pVar, ImageView imageView) {
        this.a = pVar;
        this.b = imageView;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        if (aVar != null) {
            aVar.a(this.b);
        }
    }
}
