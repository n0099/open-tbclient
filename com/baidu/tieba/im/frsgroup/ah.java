package com.baidu.tieba.im.frsgroup;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements View.OnClickListener {
    final /* synthetic */ ag a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ag agVar) {
        this.a = agVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MembersActivity membersActivity;
        membersActivity = this.a.a;
        membersActivity.finish();
    }
}
