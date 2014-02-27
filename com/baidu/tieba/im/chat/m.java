package com.baidu.tieba.im.chat;

import android.view.View;
import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class m implements View.OnClickListener {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(a aVar) {
        this.a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ImageView imageView;
        r0.a(this.a.G);
        imageView = this.a.E;
        imageView.postDelayed(new n(this), 100L);
    }
}
