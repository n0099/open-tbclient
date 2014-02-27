package com.baidu.tieba;

import android.view.View;
/* loaded from: classes.dex */
final class ap implements View.OnClickListener {
    final /* synthetic */ an a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(an anVar) {
        this.a = anVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        aq aqVar;
        aqVar = this.a.h;
        aqVar.a();
    }
}
