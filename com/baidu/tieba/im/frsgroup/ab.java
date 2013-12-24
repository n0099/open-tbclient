package com.baidu.tieba.im.frsgroup;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements View.OnClickListener {
    final /* synthetic */ aa a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(aa aaVar) {
        this.a = aaVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MembersActivity membersActivity;
        membersActivity = this.a.a;
        membersActivity.finish();
    }
}
