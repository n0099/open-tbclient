package com.baidu.tieba.im.chat;

import android.view.View;
import com.baidu.tieba.view.HeadImageView;
/* loaded from: classes.dex */
class cw implements com.baidu.tieba.util.cj {
    final /* synthetic */ cv a;
    private final /* synthetic */ String b;
    private final /* synthetic */ com.baidu.adp.widget.ImageView.b c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cw(cv cvVar, String str, com.baidu.adp.widget.ImageView.b bVar) {
        this.a = cvVar;
        this.b = str;
        this.c = bVar;
    }

    @Override // com.baidu.tieba.util.cj
    public boolean a(View view) {
        if ((view instanceof HeadImageView) && this.b.equals(view.getTag())) {
            view.setTag(null);
            HeadImageView headImageView = (HeadImageView) view;
            headImageView.a();
            this.c.a(headImageView);
            return false;
        }
        return false;
    }
}
