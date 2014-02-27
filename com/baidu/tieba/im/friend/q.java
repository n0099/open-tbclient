package com.baidu.tieba.im.friend;

import android.view.ViewGroup;
import com.baidu.tieba.util.ch;
import com.baidu.tieba.util.cj;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class q implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ o a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(o oVar) {
        this.a = oVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        viewGroup = this.a.f;
        if (viewGroup != null && str != null) {
            viewGroup2 = this.a.f;
            ch.a(viewGroup2, false, (cj) new r(this, str, bVar));
        }
    }
}
