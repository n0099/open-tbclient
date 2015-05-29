package com.baidu.tbadk.mvc.c.a;

import android.view.View;
import com.baidu.tbadk.core.view.ak;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements ak {
    final /* synthetic */ b anK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.anK = bVar;
    }

    @Override // com.baidu.tbadk.core.view.ak
    public void a(View view, boolean z) {
        com.baidu.tbadk.mvc.c.b u = com.baidu.tbadk.mvc.h.a.u(view);
        if (u != null) {
            u.aZ(z);
            u.setView(view);
            this.anK.dispatchMvcEvent(u);
        }
    }
}
