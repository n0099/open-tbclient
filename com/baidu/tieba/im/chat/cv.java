package com.baidu.tieba.im.chat;

import android.view.View;
import com.baidu.tieba.view.HeadImageView;
/* loaded from: classes.dex */
final class cv implements com.baidu.tieba.util.cj {
    final /* synthetic */ cu a;
    private final /* synthetic */ String b;
    private final /* synthetic */ com.baidu.adp.widget.ImageView.b c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cv(cu cuVar, String str, com.baidu.adp.widget.ImageView.b bVar) {
        this.a = cuVar;
        this.b = str;
        this.c = bVar;
    }

    @Override // com.baidu.tieba.util.cj
    public final boolean a(View view) {
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
