package com.baidu.tieba.im.friend;

import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
class i implements View.OnClickListener {
    final /* synthetic */ InviteFriendCandidateList bbF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(InviteFriendCandidateList inviteFriendCandidateList) {
        this.bbF = inviteFriendCandidateList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        boolean OE;
        j jVar;
        j jVar2;
        linearLayout = this.bbF.mLayout;
        linearLayout.removeView(view);
        OE = this.bbF.OE();
        if (!OE) {
            this.bbF.OC();
        }
        jVar = this.bbF.bbE;
        if (jVar != null) {
            jVar2 = this.bbF.bbE;
            jVar2.a(view, view.getTag());
        }
    }
}
