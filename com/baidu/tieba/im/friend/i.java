package com.baidu.tieba.im.friend;

import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
class i implements View.OnClickListener {
    final /* synthetic */ InviteFriendCandidateList bbG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(InviteFriendCandidateList inviteFriendCandidateList) {
        this.bbG = inviteFriendCandidateList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        boolean OJ;
        j jVar;
        j jVar2;
        linearLayout = this.bbG.mLayout;
        linearLayout.removeView(view);
        OJ = this.bbG.OJ();
        if (!OJ) {
            this.bbG.OH();
        }
        jVar = this.bbG.bbF;
        if (jVar != null) {
            jVar2 = this.bbG.bbF;
            jVar2.a(view, view.getTag());
        }
    }
}
