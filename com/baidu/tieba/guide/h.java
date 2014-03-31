package com.baidu.tieba.guide;

import android.view.ViewGroup;
import com.baidu.tbadk.core.util.bn;
import com.baidu.tbadk.core.util.bp;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class h implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ g a;
    private final /* synthetic */ ViewGroup b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar, ViewGroup viewGroup) {
        this.a = gVar;
        this.b = viewGroup;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        if (bVar != null) {
            bn.a(this.b, false, (bp) new i(this, str));
        }
    }
}
