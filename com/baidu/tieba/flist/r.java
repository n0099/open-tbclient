package com.baidu.tieba.flist;

import android.widget.ImageView;
/* loaded from: classes.dex */
class r implements com.baidu.tbadk.imageManager.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f1202a;
    final /* synthetic */ ImageView b;
    final /* synthetic */ q c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar, String str, ImageView imageView) {
        this.c = qVar;
        this.f1202a = str;
        this.b = imageView;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        if (str.equals(this.f1202a)) {
            this.b.invalidate();
        }
    }
}
