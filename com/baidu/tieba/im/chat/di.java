package com.baidu.tieba.im.chat;

import android.view.View;
import com.baidu.tbadk.core.view.HeadImageView;
/* loaded from: classes.dex */
class di implements com.baidu.tbadk.core.util.bz {
    final /* synthetic */ dh a;
    private final /* synthetic */ String b;
    private final /* synthetic */ com.baidu.adp.widget.a.a c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public di(dh dhVar, String str, com.baidu.adp.widget.a.a aVar) {
        this.a = dhVar;
        this.b = str;
        this.c = aVar;
    }

    @Override // com.baidu.tbadk.core.util.bz
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
