package com.baidu.tieba.im.friend;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.bz;
/* loaded from: classes.dex */
class z implements bz {
    final /* synthetic */ y a;
    private final /* synthetic */ String b;
    private final /* synthetic */ com.baidu.adp.widget.a.a c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar, String str, com.baidu.adp.widget.a.a aVar) {
        this.a = yVar;
        this.b = str;
        this.c = aVar;
    }

    @Override // com.baidu.tbadk.core.util.bz
    public boolean a(View view) {
        if ((view instanceof ImageView) && view.getTag() != null) {
            Object tag = view.getTag();
            if (tag instanceof com.baidu.tbadk.coreExtra.relationship.b) {
                ImageView imageView = (ImageView) view;
                com.baidu.tbadk.coreExtra.relationship.b bVar = (com.baidu.tbadk.coreExtra.relationship.b) tag;
                if (this.b != null && this.b.equals(bVar.d())) {
                    this.c.a(imageView);
                }
            }
        }
        return false;
    }
}
