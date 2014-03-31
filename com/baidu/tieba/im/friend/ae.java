package com.baidu.tieba.im.friend;

import com.baidu.tbadk.core.view.TbCheckBox;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ae implements com.baidu.tbadk.core.view.o {
    final /* synthetic */ y a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(y yVar) {
        this.a = yVar;
    }

    @Override // com.baidu.tbadk.core.view.o
    public final void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
        InviteFriendCandidateList inviteFriendCandidateList;
        InviteFriendListActivity inviteFriendListActivity;
        InviteFriendListActivity inviteFriendListActivity2;
        int i;
        this.a.i();
        if (obj != null && (obj instanceof com.baidu.tieba.im.data.c)) {
            if (z) {
                int l = this.a.l();
                inviteFriendCandidateList = this.a.j;
                if (l <= inviteFriendCandidateList.b()) {
                    inviteFriendListActivity = this.a.a;
                    inviteFriendListActivity2 = this.a.a;
                    String string = inviteFriendListActivity2.getString(com.baidu.tieba.im.j.invite_friend_exceed_max_count);
                    i = this.a.n;
                    inviteFriendListActivity.showToast(String.format(string, Integer.valueOf(i)));
                    tbCheckBox.setChecked(false);
                    ((com.baidu.tieba.im.data.c) obj).setChecked(false);
                    return;
                }
                this.a.b((com.baidu.tieba.im.data.c) obj);
                return;
            }
            this.a.c((com.baidu.tieba.im.data.c) obj);
        }
    }
}
