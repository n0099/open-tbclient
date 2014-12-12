package com.baidu.tieba.im.friend;

import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tbadk.core.view.ai;
import com.baidu.tieba.z;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements ai {
    final /* synthetic */ s baL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(s sVar) {
        this.baL = sVar;
    }

    @Override // com.baidu.tbadk.core.view.ai
    public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
        InviteFriendCandidateList inviteFriendCandidateList;
        InviteFriendListActivity inviteFriendListActivity;
        InviteFriendListActivity inviteFriendListActivity2;
        int i;
        this.baL.hideKeyboard();
        if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.b)) {
            if (z) {
                int Ox = this.baL.Ox();
                inviteFriendCandidateList = this.baL.baF;
                if (Ox <= inviteFriendCandidateList.getItemLength()) {
                    inviteFriendListActivity = this.baL.baB;
                    inviteFriendListActivity2 = this.baL.baB;
                    String string = inviteFriendListActivity2.getPageContext().getString(z.invite_friend_exceed_max_count);
                    i = this.baL.baJ;
                    inviteFriendListActivity.showToast(String.format(string, Integer.valueOf(i)));
                    tbCheckBox.setChecked(false);
                    ((com.baidu.tbadk.coreExtra.relationship.b) obj).setChecked(false);
                    return;
                }
                this.baL.g((com.baidu.tbadk.coreExtra.relationship.b) obj);
                return;
            }
            this.baL.h((com.baidu.tbadk.coreExtra.relationship.b) obj);
        }
    }
}
