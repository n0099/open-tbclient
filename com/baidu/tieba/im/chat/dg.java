package com.baidu.tieba.im.chat;

import android.view.View;
import com.baidu.tbadk.core.view.HeadImageView;
/* loaded from: classes.dex */
final class dg implements com.baidu.tbadk.core.util.bp {
    final /* synthetic */ df a;
    private final /* synthetic */ String b;
    private final /* synthetic */ com.baidu.adp.widget.ImageView.b c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dg(df dfVar, String str, com.baidu.adp.widget.ImageView.b bVar) {
        this.a = dfVar;
        this.b = str;
        this.c = bVar;
    }

    @Override // com.baidu.tbadk.core.util.bp
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
