package com.baidu.tieba.im.frsgroup;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class af implements View.OnClickListener {
    final /* synthetic */ ae a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ae aeVar) {
        this.a = aeVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        MembersActivity membersActivity;
        membersActivity = this.a.a;
        membersActivity.finish();
    }
}
