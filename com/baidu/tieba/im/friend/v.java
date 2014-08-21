package com.baidu.tieba.im.friend;

import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.x;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements com.baidu.tbadk.core.view.t {
    final /* synthetic */ s a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(s sVar) {
        this.a = sVar;
    }

    @Override // com.baidu.tbadk.core.view.t
    public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
        InviteFriendCandidateList inviteFriendCandidateList;
        InviteFriendListActivity inviteFriendListActivity;
        InviteFriendListActivity inviteFriendListActivity2;
        int i;
        this.a.f();
        if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.b)) {
            if (z) {
                int i2 = this.a.i();
                inviteFriendCandidateList = this.a.j;
                if (i2 <= inviteFriendCandidateList.b()) {
                    inviteFriendListActivity = this.a.a;
                    inviteFriendListActivity2 = this.a.a;
                    String string = inviteFriendListActivity2.getString(x.invite_friend_exceed_max_count);
                    i = this.a.n;
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
