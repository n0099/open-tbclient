package com.baidu.tieba.im.frsgroup;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements View.OnClickListener {
    final /* synthetic */ ah aYz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ah ahVar) {
        this.aYz = ahVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MembersActivity membersActivity;
        membersActivity = this.aYz.aYf;
        membersActivity.finish();
    }
}
