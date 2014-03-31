package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.bn;
import com.baidu.tbadk.core.util.bp;
/* loaded from: classes.dex */
final class f implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ c a;
    private final /* synthetic */ View b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar, View view) {
        this.a = cVar;
        this.b = view;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        if (bVar != null && this.b != null && (this.b instanceof ViewGroup)) {
            bn.a((ViewGroup) this.b, false, (bp) new g(this, str, bVar));
        }
    }
}
