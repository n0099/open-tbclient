package com.baidu.tieba.im.friend;

import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements com.baidu.tbadk.core.view.w {
    final /* synthetic */ s aWt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(s sVar) {
        this.aWt = sVar;
    }

    @Override // com.baidu.tbadk.core.view.w
    public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
        InviteFriendCandidateList inviteFriendCandidateList;
        InviteFriendListActivity inviteFriendListActivity;
        InviteFriendListActivity inviteFriendListActivity2;
        int i;
        this.aWt.Nm();
        if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.b)) {
            if (z) {
                int No = this.aWt.No();
                inviteFriendCandidateList = this.aWt.aWn;
                if (No <= inviteFriendCandidateList.getItemLength()) {
                    inviteFriendListActivity = this.aWt.aWj;
                    inviteFriendListActivity2 = this.aWt.aWj;
                    String string = inviteFriendListActivity2.getString(y.invite_friend_exceed_max_count);
                    i = this.aWt.aWr;
                    inviteFriendListActivity.showToast(String.format(string, Integer.valueOf(i)));
                    tbCheckBox.setChecked(false);
                    ((com.baidu.tbadk.coreExtra.relationship.b) obj).setChecked(false);
                    return;
                }
                this.aWt.g((com.baidu.tbadk.coreExtra.relationship.b) obj);
                return;
            }
            this.aWt.h((com.baidu.tbadk.coreExtra.relationship.b) obj);
        }
    }
}
