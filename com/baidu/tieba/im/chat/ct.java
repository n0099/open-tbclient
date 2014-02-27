package com.baidu.tieba.im.chat;

import android.view.View;
import com.baidu.adp.widget.ImageView.BDImageView2;
/* loaded from: classes.dex */
final class ct implements com.baidu.tieba.util.cj {
    final /* synthetic */ cs a;
    private final /* synthetic */ String b;
    private final /* synthetic */ com.baidu.adp.widget.ImageView.b c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ct(cs csVar, String str, com.baidu.adp.widget.ImageView.b bVar) {
        this.a = csVar;
        this.b = str;
        this.c = bVar;
    }

    @Override // com.baidu.tieba.util.cj
    public final boolean a(View view) {
        if ((view instanceof BDImageView2) && this.b.equals(view.getTag())) {
            view.setTag(null);
            BDImageView2 bDImageView2 = (BDImageView2) view;
            bDImageView2.a();
            this.c.a(bDImageView2);
            return false;
        }
        return false;
    }
}
