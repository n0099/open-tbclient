package com.baidu.tieba.im.chat;

import android.view.View;
import com.baidu.adp.widget.ImageView.BDImageView2;
/* loaded from: classes.dex */
class cg implements com.baidu.tieba.util.bl {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f1590a;
    final /* synthetic */ com.baidu.adp.widget.ImageView.e b;
    final /* synthetic */ cf c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cg(cf cfVar, String str, com.baidu.adp.widget.ImageView.e eVar) {
        this.c = cfVar;
        this.f1590a = str;
        this.b = eVar;
    }

    @Override // com.baidu.tieba.util.bl
    public boolean a(View view) {
        if ((view instanceof BDImageView2) && this.f1590a.equals(view.getTag())) {
            view.setTag(null);
            BDImageView2 bDImageView2 = (BDImageView2) view;
            bDImageView2.a();
            this.b.a(bDImageView2);
            return false;
        }
        return false;
    }
}
