package com.baidu.tbadk.mvc.c.a;

import android.view.View;
import com.baidu.tbadk.core.view.af;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements af {
    final /* synthetic */ b amz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.amz = bVar;
    }

    @Override // com.baidu.tbadk.core.view.af
    public void a(View view, boolean z) {
        com.baidu.tbadk.mvc.c.b r = com.baidu.tbadk.mvc.h.a.r(view);
        if (r != null) {
            r.aS(z);
            r.setView(view);
            this.amz.dispatchMvcEvent(r);
        }
    }
}
