package com.baidu.tieba.im.friend;

import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
class i implements View.OnClickListener {
    final /* synthetic */ InviteFriendCandidateList aVF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(InviteFriendCandidateList inviteFriendCandidateList) {
        this.aVF = inviteFriendCandidateList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        boolean MY;
        j jVar;
        j jVar2;
        linearLayout = this.aVF.mLayout;
        linearLayout.removeView(view);
        MY = this.aVF.MY();
        if (!MY) {
            this.aVF.MW();
        }
        jVar = this.aVF.aVE;
        if (jVar != null) {
            jVar2 = this.aVF.aVE;
            jVar2.a(view, view.getTag());
        }
    }
}
