package com.baidu.tieba.im.chat;

import android.view.View;
import com.baidu.adp.widget.ImageView.BDImageView2;
/* loaded from: classes.dex */
final class de implements com.baidu.tbadk.core.util.bp {
    final /* synthetic */ dd a;
    private final /* synthetic */ String b;
    private final /* synthetic */ com.baidu.adp.widget.ImageView.b c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public de(dd ddVar, String str, com.baidu.adp.widget.ImageView.b bVar) {
        this.a = ddVar;
        this.b = str;
        this.c = bVar;
    }

    @Override // com.baidu.tbadk.core.util.bp
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
