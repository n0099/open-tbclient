package com.baidu.tieba.im.friend;

import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
class l implements View.OnClickListener {
    final /* synthetic */ InviteFriendCandidateList a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(InviteFriendCandidateList inviteFriendCandidateList) {
        this.a = inviteFriendCandidateList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        boolean f;
        m mVar;
        m mVar2;
        linearLayout = this.a.b;
        linearLayout.removeView(view);
        f = this.a.f();
        if (!f) {
            this.a.d();
        }
        mVar = this.a.i;
        if (mVar != null) {
            mVar2 = this.a.i;
            mVar2.a(view, view.getTag());
        }
    }
}
