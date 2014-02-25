package com.baidu.tieba.im.friend;

import com.baidu.tieba.view.TbCheckBox;
import com.baidu.tieba.view.cr;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements cr {
    final /* synthetic */ u a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(u uVar) {
        this.a = uVar;
    }

    @Override // com.baidu.tieba.view.cr
    public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
        InviteFriendCandidateList inviteFriendCandidateList;
        InviteFriendListActivity inviteFriendListActivity;
        InviteFriendListActivity inviteFriendListActivity2;
        int i;
        this.a.k();
        if (obj != null && (obj instanceof com.baidu.tieba.im.data.d)) {
            if (z) {
                int n = this.a.n();
                inviteFriendCandidateList = this.a.j;
                if (n <= inviteFriendCandidateList.getItemLength()) {
                    inviteFriendListActivity = this.a.a;
                    inviteFriendListActivity2 = this.a.a;
                    String string = inviteFriendListActivity2.getString(R.string.invite_friend_exceed_max_count);
                    i = this.a.n;
                    inviteFriendListActivity.showToast(String.format(string, Integer.valueOf(i)));
                    tbCheckBox.setChecked(false);
                    ((com.baidu.tieba.im.data.d) obj).setChecked(false);
                    return;
                }
                this.a.a((com.baidu.tieba.im.data.d) obj);
                return;
            }
            this.a.b((com.baidu.tieba.im.data.d) obj);
        }
    }
}
