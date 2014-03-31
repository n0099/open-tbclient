package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.bn;
import com.baidu.tbadk.core.util.bp;
/* loaded from: classes.dex */
final class bj implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ bg a;
    private final /* synthetic */ View b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(bg bgVar, View view) {
        this.a = bgVar;
        this.b = view;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        if (bVar != null && this.b != null && (this.b instanceof ViewGroup)) {
            bn.a((ViewGroup) this.b, false, (bp) new bk(this, str, bVar));
        }
    }
}
