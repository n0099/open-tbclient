package com.baidu.tieba.im.friend;

import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tbadk.core.view.ai;
import com.baidu.tieba.z;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements ai {
    final /* synthetic */ s bcg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(s sVar) {
        this.bcg = sVar;
    }

    @Override // com.baidu.tbadk.core.view.ai
    public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
        InviteFriendCandidateList inviteFriendCandidateList;
        InviteFriendListActivity inviteFriendListActivity;
        InviteFriendListActivity inviteFriendListActivity2;
        int i;
        this.bcg.OT();
        if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.b)) {
            if (z) {
                int OU = this.bcg.OU();
                inviteFriendCandidateList = this.bcg.bca;
                if (OU <= inviteFriendCandidateList.getItemLength()) {
                    inviteFriendListActivity = this.bcg.bbW;
                    inviteFriendListActivity2 = this.bcg.bbW;
                    String string = inviteFriendListActivity2.getPageContext().getString(z.invite_friend_exceed_max_count);
                    i = this.bcg.bce;
                    inviteFriendListActivity.showToast(String.format(string, Integer.valueOf(i)));
                    tbCheckBox.setChecked(false);
                    ((com.baidu.tbadk.coreExtra.relationship.b) obj).setChecked(false);
                    return;
                }
                this.bcg.g((com.baidu.tbadk.coreExtra.relationship.b) obj);
                return;
            }
            this.bcg.h((com.baidu.tbadk.coreExtra.relationship.b) obj);
        }
    }
}
