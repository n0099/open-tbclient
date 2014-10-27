package com.baidu.tieba.im.friend;

import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements com.baidu.tbadk.core.view.w {
    final /* synthetic */ s aWf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(s sVar) {
        this.aWf = sVar;
    }

    @Override // com.baidu.tbadk.core.view.w
    public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
        InviteFriendCandidateList inviteFriendCandidateList;
        InviteFriendListActivity inviteFriendListActivity;
        InviteFriendListActivity inviteFriendListActivity2;
        int i;
        this.aWf.Ni();
        if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.b)) {
            if (z) {
                int Nk = this.aWf.Nk();
                inviteFriendCandidateList = this.aWf.aVZ;
                if (Nk <= inviteFriendCandidateList.getItemLength()) {
                    inviteFriendListActivity = this.aWf.aVV;
                    inviteFriendListActivity2 = this.aWf.aVV;
                    String string = inviteFriendListActivity2.getString(y.invite_friend_exceed_max_count);
                    i = this.aWf.aWd;
                    inviteFriendListActivity.showToast(String.format(string, Integer.valueOf(i)));
                    tbCheckBox.setChecked(false);
                    ((com.baidu.tbadk.coreExtra.relationship.b) obj).setChecked(false);
                    return;
                }
                this.aWf.g((com.baidu.tbadk.coreExtra.relationship.b) obj);
                return;
            }
            this.aWf.h((com.baidu.tbadk.coreExtra.relationship.b) obj);
        }
    }
}
