package com.baidu.tieba.im.chat;

import android.view.View;
import com.baidu.tieba.view.HeadImageView;
/* loaded from: classes.dex */
class cs implements com.baidu.tieba.util.bm {
    final /* synthetic */ String a;
    final /* synthetic */ com.baidu.adp.widget.ImageView.e b;
    final /* synthetic */ cr c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cs(cr crVar, String str, com.baidu.adp.widget.ImageView.e eVar) {
        this.c = crVar;
        this.a = str;
        this.b = eVar;
    }

    @Override // com.baidu.tieba.util.bm
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
