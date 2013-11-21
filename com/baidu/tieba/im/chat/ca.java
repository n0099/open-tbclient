package com.baidu.tieba.im.chat;

import android.view.View;
import com.baidu.adp.widget.ImageView.BDImageView2;
/* loaded from: classes.dex */
class ca implements com.baidu.tieba.util.bn {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f1537a;
    final /* synthetic */ com.baidu.adp.widget.ImageView.e b;
    final /* synthetic */ bz c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(bz bzVar, String str, com.baidu.adp.widget.ImageView.e eVar) {
        this.c = bzVar;
        this.f1537a = str;
        this.b = eVar;
    }

    @Override // com.baidu.tieba.util.bn
    public boolean a(View view) {
        if ((view instanceof BDImageView2) && this.f1537a.equals(view.getTag())) {
            view.setTag(null);
            BDImageView2 bDImageView2 = (BDImageView2) view;
            bDImageView2.a();
            this.b.a(bDImageView2);
            return false;
        }
        return false;
    }
}
