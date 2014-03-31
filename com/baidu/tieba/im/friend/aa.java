package com.baidu.tieba.im.friend;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.bp;
/* loaded from: classes.dex */
final class aa implements bp {
    final /* synthetic */ z a;
    private final /* synthetic */ String b;
    private final /* synthetic */ com.baidu.adp.widget.ImageView.b c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(z zVar, String str, com.baidu.adp.widget.ImageView.b bVar) {
        this.a = zVar;
        this.b = str;
        this.c = bVar;
    }

    @Override // com.baidu.tbadk.core.util.bp
    public final boolean a(View view) {
        if ((view instanceof ImageView) && view.getTag() != null) {
            Object tag = view.getTag();
            if (tag instanceof com.baidu.tieba.im.data.c) {
                ImageView imageView = (ImageView) view;
                com.baidu.tieba.im.data.c cVar = (com.baidu.tieba.im.data.c) tag;
                if (this.b != null && this.b.equals(cVar.c())) {
                    this.c.a(imageView);
                }
            }
        }
        return false;
    }
}
