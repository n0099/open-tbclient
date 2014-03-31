package com.baidu.tieba.im.frsgroup;

import android.view.View;
/* loaded from: classes.dex */
final class j implements View.OnClickListener {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(b bVar) {
        this.a = bVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        FrsGroupActivity frsGroupActivity;
        FrsGroupActivity frsGroupActivity2;
        frsGroupActivity = this.a.a;
        if (frsGroupActivity != null) {
            frsGroupActivity2 = this.a.a;
            frsGroupActivity2.h();
        }
    }
}
