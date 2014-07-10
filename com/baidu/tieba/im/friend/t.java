package com.baidu.tieba.im.friend;

import android.view.ViewGroup;
import com.baidu.tbadk.core.util.bx;
import com.baidu.tbadk.core.util.bz;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ r a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(r rVar) {
        this.a = rVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        viewGroup = this.a.f;
        if (viewGroup != null && str != null) {
            viewGroup2 = this.a.f;
            bx.a(viewGroup2, false, (bz) new u(this, str, aVar));
        }
    }
}
