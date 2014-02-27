package com.baidu.tieba.im.frsgroup;

import android.view.View;
/* loaded from: classes.dex */
final class h implements View.OnClickListener {
    final /* synthetic */ c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(c cVar) {
        this.a = cVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        FrsGroupActivity frsGroupActivity;
        FrsGroupActivity frsGroupActivity2;
        frsGroupActivity = this.a.b;
        if (frsGroupActivity != null) {
            frsGroupActivity2 = this.a.b;
            frsGroupActivity2.g();
        }
    }
}
