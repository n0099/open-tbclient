package com.baidu.tieba.im.friend;

import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
final class i implements View.OnClickListener {
    final /* synthetic */ InviteFriendCandidateList a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(InviteFriendCandidateList inviteFriendCandidateList) {
        this.a = inviteFriendCandidateList;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        LinearLayout linearLayout;
        boolean c;
        j jVar;
        j jVar2;
        linearLayout = this.a.b;
        linearLayout.removeView(view);
        c = this.a.c();
        if (!c) {
            this.a.b();
        }
        jVar = this.a.i;
        if (jVar != null) {
            jVar2 = this.a.i;
            jVar2.a(view.getTag());
        }
    }
}
