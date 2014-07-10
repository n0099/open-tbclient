package com.baidu.tieba.im.friend;

import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
class k implements View.OnClickListener {
    final /* synthetic */ InviteFriendCandidateList a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(InviteFriendCandidateList inviteFriendCandidateList) {
        this.a = inviteFriendCandidateList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        boolean f;
        l lVar;
        l lVar2;
        linearLayout = this.a.b;
        linearLayout.removeView(view);
        f = this.a.f();
        if (!f) {
            this.a.d();
        }
        lVar = this.a.i;
        if (lVar != null) {
            lVar2 = this.a.i;
            lVar2.a(view, view.getTag());
        }
    }
}
