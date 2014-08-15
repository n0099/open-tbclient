package com.baidu.tieba.im.friend;

import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
class i implements View.OnClickListener {
    final /* synthetic */ InviteFriendCandidateList a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(InviteFriendCandidateList inviteFriendCandidateList) {
        this.a = inviteFriendCandidateList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        boolean f;
        j jVar;
        j jVar2;
        linearLayout = this.a.b;
        linearLayout.removeView(view);
        f = this.a.f();
        if (!f) {
            this.a.d();
        }
        jVar = this.a.h;
        if (jVar != null) {
            jVar2 = this.a.h;
            jVar2.a(view, view.getTag());
        }
    }
}
