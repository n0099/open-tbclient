package com.baidu.tieba.flist;

import android.widget.ImageView;
/* loaded from: classes.dex */
class q implements com.baidu.tbadk.a.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ p f1052a;
    private final /* synthetic */ String b;
    private final /* synthetic */ ImageView c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, String str, ImageView imageView) {
        this.f1052a = pVar;
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
