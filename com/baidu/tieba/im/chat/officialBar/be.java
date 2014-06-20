package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.br;
import com.baidu.tbadk.core.util.bt;
/* loaded from: classes.dex */
class be implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ bb a;
    private final /* synthetic */ View b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(bb bbVar, View view) {
        this.a = bbVar;
        this.b = view;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        if (aVar != null && this.b != null && (this.b instanceof ViewGroup)) {
            br.a((ViewGroup) this.b, false, (bt) new bf(this, str, aVar));
        }
    }
}
