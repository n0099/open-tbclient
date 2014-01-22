package com.baidu.tieba.im.chat;

import android.view.View;
import com.baidu.adp.widget.ImageView.BDImageView2;
/* loaded from: classes.dex */
class ck implements com.baidu.tieba.util.cg {
    final /* synthetic */ String a;
    final /* synthetic */ com.baidu.adp.widget.ImageView.d b;
    final /* synthetic */ cj c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ck(cj cjVar, String str, com.baidu.adp.widget.ImageView.d dVar) {
        this.c = cjVar;
        this.a = str;
        this.b = dVar;
    }

    @Override // com.baidu.tieba.util.cg
    public boolean a(View view) {
        if ((view instanceof BDImageView2) && this.a.equals(view.getTag())) {
            view.setTag(null);
            BDImageView2 bDImageView2 = (BDImageView2) view;
            bDImageView2.a();
            this.b.a(bDImageView2);
            return false;
        }
        return false;
    }
}
