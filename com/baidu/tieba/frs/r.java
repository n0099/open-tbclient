package com.baidu.tieba.frs;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.a();
    }
}
