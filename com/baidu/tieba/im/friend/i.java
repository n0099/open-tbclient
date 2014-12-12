package com.baidu.tieba.im.friend;

import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
class i implements View.OnClickListener {
    final /* synthetic */ InviteFriendCandidateList baj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(InviteFriendCandidateList inviteFriendCandidateList) {
        this.baj = inviteFriendCandidateList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        boolean On;
        j jVar;
        j jVar2;
        linearLayout = this.baj.mLayout;
        linearLayout.removeView(view);
        On = this.baj.On();
        if (!On) {
            this.baj.Ol();
        }
        jVar = this.baj.bai;
        if (jVar != null) {
            jVar2 = this.baj.bai;
            jVar2.a(view, view.getTag());
        }
    }
}
