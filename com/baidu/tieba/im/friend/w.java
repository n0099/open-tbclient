package com.baidu.tieba.im.friend;

import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tbadk.core.view.ai;
import com.baidu.tieba.z;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements ai {
    final /* synthetic */ s bcf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(s sVar) {
        this.bcf = sVar;
    }

    @Override // com.baidu.tbadk.core.view.ai
    public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
        InviteFriendCandidateList inviteFriendCandidateList;
        InviteFriendListActivity inviteFriendListActivity;
        InviteFriendListActivity inviteFriendListActivity2;
        int i;
        this.bcf.OO();
        if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.b)) {
            if (z) {
                int OP = this.bcf.OP();
                inviteFriendCandidateList = this.bcf.bbZ;
                if (OP <= inviteFriendCandidateList.getItemLength()) {
                    inviteFriendListActivity = this.bcf.bbV;
                    inviteFriendListActivity2 = this.bcf.bbV;
                    String string = inviteFriendListActivity2.getPageContext().getString(z.invite_friend_exceed_max_count);
                    i = this.bcf.bcd;
                    inviteFriendListActivity.showToast(String.format(string, Integer.valueOf(i)));
                    tbCheckBox.setChecked(false);
                    ((com.baidu.tbadk.coreExtra.relationship.b) obj).setChecked(false);
                    return;
                }
                this.bcf.g((com.baidu.tbadk.coreExtra.relationship.b) obj);
                return;
            }
            this.bcf.h((com.baidu.tbadk.coreExtra.relationship.b) obj);
        }
    }
}
