package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.bx;
import com.baidu.tbadk.core.util.bz;
/* loaded from: classes.dex */
class k implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ h a;
    private final /* synthetic */ View b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(h hVar, View view) {
        this.a = hVar;
        this.b = view;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        if (aVar != null && this.b != null && (this.b instanceof ViewGroup)) {
            bx.a((ViewGroup) this.b, false, (bz) new l(this, str, aVar));
        }
    }
}
