package com.baidu.tieba.im.chat;

import android.view.View;
import com.baidu.tieba.view.HeadImageView;
/* loaded from: classes.dex */
class cq implements com.baidu.tieba.util.bw {
    final /* synthetic */ String a;
    final /* synthetic */ com.baidu.adp.widget.ImageView.d b;
    final /* synthetic */ cp c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cq(cp cpVar, String str, com.baidu.adp.widget.ImageView.d dVar) {
        this.c = cpVar;
        this.a = str;
        this.b = dVar;
    }

    @Override // com.baidu.tieba.util.bw
    public boolean a(View view) {
        if ((view instanceof HeadImageView) && this.a.equals(view.getTag())) {
            view.setTag(null);
            HeadImageView headImageView = (HeadImageView) view;
            headImageView.a();
            this.b.a(headImageView);
            return false;
        }
        return false;
    }
}
