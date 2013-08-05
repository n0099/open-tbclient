package com.baidu.tieba.flist;

import android.widget.ImageView;
/* loaded from: classes.dex */
class f implements com.baidu.tbadk.a.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f1042a;
    private final /* synthetic */ String b;
    private final /* synthetic */ ImageView c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, String str, ImageView imageView) {
        this.f1042a = eVar;
        this.b = str;
        this.c = imageView;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.b bVar, String str, boolean z) {
        if (str.equals(this.b)) {
            this.c.setTag(this.b);
            this.c.invalidate();
        }
    }
}
