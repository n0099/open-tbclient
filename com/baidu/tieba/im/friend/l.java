package com.baidu.tieba.im.friend;

import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
final class l implements View.OnClickListener {
    final /* synthetic */ InviteFriendCandidateList a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(InviteFriendCandidateList inviteFriendCandidateList) {
        this.a = inviteFriendCandidateList;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        LinearLayout linearLayout;
        boolean e;
        m mVar;
        m mVar2;
        linearLayout = this.a.b;
        linearLayout.removeView(view);
        e = this.a.e();
        if (!e) {
            this.a.d();
        }
        mVar = this.a.i;
        if (mVar != null) {
            mVar2 = this.a.i;
            mVar2.a(view.getTag());
        }
    }
}
