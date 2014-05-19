package com.baidu.tieba.im.friend;

import com.baidu.tbadk.core.view.TbCheckBox;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements com.baidu.tbadk.core.view.o {
    final /* synthetic */ y a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(y yVar) {
        this.a = yVar;
    }

    @Override // com.baidu.tbadk.core.view.o
    public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
        InviteFriendCandidateList inviteFriendCandidateList;
        InviteFriendListActivity inviteFriendListActivity;
        InviteFriendListActivity inviteFriendListActivity2;
        int i;
        this.a.h();
        if (obj != null && (obj instanceof com.baidu.tieba.im.data.e)) {
            if (z) {
                int k = this.a.k();
                inviteFriendCandidateList = this.a.i;
                if (k <= inviteFriendCandidateList.b()) {
                    inviteFriendListActivity = this.a.a;
                    inviteFriendListActivity2 = this.a.a;
                    String string = inviteFriendListActivity2.getString(com.baidu.tieba.u.invite_friend_exceed_max_count);
                    i = this.a.m;
                    inviteFriendListActivity.showToast(String.format(string, Integer.valueOf(i)));
                    tbCheckBox.setChecked(false);
                    ((com.baidu.tieba.im.data.e) obj).setChecked(false);
                    return;
                }
                this.a.a((com.baidu.tieba.im.data.e) obj);
                return;
            }
            this.a.b((com.baidu.tieba.im.data.e) obj);
        }
    }
}
