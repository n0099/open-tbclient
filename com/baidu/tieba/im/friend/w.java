package com.baidu.tieba.im.friend;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tieba.util.cj;
/* loaded from: classes.dex */
final class w implements cj {
    final /* synthetic */ v a;
    private final /* synthetic */ String b;
    private final /* synthetic */ com.baidu.adp.widget.ImageView.b c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar, String str, com.baidu.adp.widget.ImageView.b bVar) {
        this.a = vVar;
        this.b = str;
        this.c = bVar;
    }

    @Override // com.baidu.tieba.util.cj
    public final boolean a(View view) {
        if ((view instanceof ImageView) && view.getTag() != null) {
            Object tag = view.getTag();
            if (tag instanceof com.baidu.tieba.im.data.d) {
                ImageView imageView = (ImageView) view;
                com.baidu.tieba.im.data.d dVar = (com.baidu.tieba.im.data.d) tag;
                if (this.b != null && this.b.equals(dVar.c())) {
                    this.c.a(imageView);
                }
            }
        }
        return false;
    }
}
