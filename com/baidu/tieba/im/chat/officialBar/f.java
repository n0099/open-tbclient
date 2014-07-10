package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.bx;
import com.baidu.tbadk.core.util.bz;
/* loaded from: classes.dex */
class f implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ c a;
    private final /* synthetic */ View b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar, View view) {
        this.a = cVar;
        this.b = view;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        if (aVar != null && this.b != null && (this.b instanceof ViewGroup)) {
            bx.a((ViewGroup) this.b, false, (bz) new g(this, str, aVar));
        }
    }
}
