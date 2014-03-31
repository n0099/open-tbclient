package com.baidu.tieba.im.frsgroup;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ai implements View.OnClickListener {
    final /* synthetic */ ah a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ah ahVar) {
        this.a = ahVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        MembersActivity membersActivity;
        membersActivity = this.a.a;
        membersActivity.finish();
    }
}
