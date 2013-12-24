package com.baidu.tieba.im.chat;

import android.view.View;
import com.baidu.adp.widget.ImageView.BDImageView2;
/* loaded from: classes.dex */
class cq implements com.baidu.tieba.util.bm {
    final /* synthetic */ String a;
    final /* synthetic */ com.baidu.adp.widget.ImageView.e b;
    final /* synthetic */ cp c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cq(cp cpVar, String str, com.baidu.adp.widget.ImageView.e eVar) {
        this.c = cpVar;
        this.a = str;
        this.b = eVar;
    }

    @Override // com.baidu.tieba.util.bm
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
