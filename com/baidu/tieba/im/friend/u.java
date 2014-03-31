package com.baidu.tieba.im.friend;

import android.view.ViewGroup;
import com.baidu.tbadk.core.util.bn;
import com.baidu.tbadk.core.util.bp;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class u implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ s a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(s sVar) {
        this.a = sVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        viewGroup = this.a.f;
        if (viewGroup != null && str != null) {
            viewGroup2 = this.a.f;
            bn.a(viewGroup2, false, (bp) new v(this, str, bVar));
        }
    }
}
