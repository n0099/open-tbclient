package com.baidu.tieba.im.groupInfo;

import android.view.View;
/* loaded from: classes.dex */
class d implements View.OnClickListener {
    final /* synthetic */ ApplyJoinGroupActivity bad;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ApplyJoinGroupActivity applyJoinGroupActivity) {
        this.bad = applyJoinGroupActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.equals(this.bad.aZV)) {
                if (!com.baidu.adp.lib.util.j.fh()) {
                    this.bad.showToast(com.baidu.tieba.y.neterror);
                    return;
                }
                RequestJoinGroupMessage requestJoinGroupMessage = new RequestJoinGroupMessage();
                requestJoinGroupMessage.setGroupId(com.baidu.adp.lib.g.c.f(this.bad.aZZ, 0));
                requestJoinGroupMessage.setUserMsg(this.bad.aZR.getText().toString());
                requestJoinGroupMessage.setJoinType(this.bad.joinType);
                requestJoinGroupMessage.setInviteUserId(this.bad.inviteUserId);
                this.bad.aZV.setEnabled(false);
                this.bad.sendMessage(requestJoinGroupMessage);
            } else if (view.equals(this.bad.aZU)) {
                this.bad.finish();
            }
        }
    }
}
