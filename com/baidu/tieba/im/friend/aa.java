package com.baidu.tieba.im.friend;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.br;
/* loaded from: classes.dex */
class aa implements br {
    final /* synthetic */ z a;
    private final /* synthetic */ String b;
    private final /* synthetic */ com.baidu.adp.widget.a.a c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(z zVar, String str, com.baidu.adp.widget.a.a aVar) {
        this.a = zVar;
        this.b = str;
        this.c = aVar;
    }

    @Override // com.baidu.tbadk.core.util.br
    public boolean a(View view) {
        if ((view instanceof ImageView) && view.getTag() != null) {
            Object tag = view.getTag();
            if (tag instanceof com.baidu.tieba.im.data.e) {
                ImageView imageView = (ImageView) view;
                com.baidu.tieba.im.data.e eVar = (com.baidu.tieba.im.data.e) tag;
                if (this.b != null && this.b.equals(eVar.c())) {
                    this.c.a(imageView);
                }
            }
        }
        return false;
    }
}
