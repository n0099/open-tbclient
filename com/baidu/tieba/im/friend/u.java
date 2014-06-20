package com.baidu.tieba.im.friend;

import android.view.ViewGroup;
import com.baidu.tbadk.core.util.br;
import com.baidu.tbadk.core.util.bt;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ s a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(s sVar) {
        this.a = sVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        viewGroup = this.a.f;
        if (viewGroup != null && str != null) {
            viewGroup2 = this.a.f;
            br.a(viewGroup2, false, (bt) new v(this, str, aVar));
        }
    }
}
