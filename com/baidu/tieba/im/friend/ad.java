package com.baidu.tieba.im.friend;

import com.baidu.tbadk.core.view.TbCheckBox;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements com.baidu.tbadk.core.view.o {
    final /* synthetic */ x a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(x xVar) {
        this.a = xVar;
    }

    @Override // com.baidu.tbadk.core.view.o
    public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
        InviteFriendCandidateList inviteFriendCandidateList;
        InviteFriendListActivity inviteFriendListActivity;
        InviteFriendListActivity inviteFriendListActivity2;
        int i;
        this.a.g();
        if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.b)) {
            if (z) {
                int j = this.a.j();
                inviteFriendCandidateList = this.a.i;
                if (j <= inviteFriendCandidateList.b()) {
                    inviteFriendListActivity = this.a.a;
                    inviteFriendListActivity2 = this.a.a;
                    String string = inviteFriendListActivity2.getString(com.baidu.tieba.y.invite_friend_exceed_max_count);
                    i = this.a.m;
                    inviteFriendListActivity.showToast(String.format(string, Integer.valueOf(i)));
                    tbCheckBox.setChecked(false);
                    ((com.baidu.tbadk.coreExtra.relationship.b) obj).setChecked(false);
                    return;
                }
                this.a.a((com.baidu.tbadk.coreExtra.relationship.b) obj);
                return;
            }
            this.a.b((com.baidu.tbadk.coreExtra.relationship.b) obj);
        }
    }
}
