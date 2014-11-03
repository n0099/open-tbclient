package com.baidu.tieba.im.friend;

import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
class i implements View.OnClickListener {
    final /* synthetic */ InviteFriendCandidateList aVT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(InviteFriendCandidateList inviteFriendCandidateList) {
        this.aVT = inviteFriendCandidateList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        boolean Nc;
        j jVar;
        j jVar2;
        linearLayout = this.aVT.mLayout;
        linearLayout.removeView(view);
        Nc = this.aVT.Nc();
        if (!Nc) {
            this.aVT.Na();
        }
        jVar = this.aVT.aVS;
        if (jVar != null) {
            jVar2 = this.aVT.aVS;
            jVar2.a(view, view.getTag());
        }
    }
}
