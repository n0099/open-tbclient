package com.baidu.tieba.im.chat;

import android.view.View;
import com.baidu.tbadk.core.view.HeadImageView;
/* loaded from: classes.dex */
class da implements com.baidu.tbadk.core.util.bt {
    final /* synthetic */ cz a;
    private final /* synthetic */ String b;
    private final /* synthetic */ com.baidu.adp.widget.a.a c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public da(cz czVar, String str, com.baidu.adp.widget.a.a aVar) {
        this.a = czVar;
        this.b = str;
        this.c = aVar;
    }

    @Override // com.baidu.tbadk.core.util.bt
    public boolean a(View view) {
        if ((view instanceof HeadImageView) && this.b.equals(view.getTag())) {
            view.setTag(null);
            HeadImageView headImageView = (HeadImageView) view;
            headImageView.f();
            this.c.a(headImageView);
            return false;
        }
        return false;
    }
}
