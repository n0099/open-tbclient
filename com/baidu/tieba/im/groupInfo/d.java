package com.baidu.tieba.im.groupInfo;

import android.view.View;
/* loaded from: classes.dex */
class d implements View.OnClickListener {
    final /* synthetic */ ApplyJoinGroupActivity baq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ApplyJoinGroupActivity applyJoinGroupActivity) {
        this.baq = applyJoinGroupActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.equals(this.baq.bai)) {
                if (!com.baidu.adp.lib.util.j.fh()) {
                    this.baq.showToast(com.baidu.tieba.y.neterror);
                    return;
                }
                RequestJoinGroupMessage requestJoinGroupMessage = new RequestJoinGroupMessage();
                requestJoinGroupMessage.setGroupId(com.baidu.adp.lib.g.c.f(this.baq.bam, 0));
                requestJoinGroupMessage.setUserMsg(this.baq.bae.getText().toString());
                requestJoinGroupMessage.setJoinType(this.baq.joinType);
                requestJoinGroupMessage.setInviteUserId(this.baq.inviteUserId);
                this.baq.bai.setEnabled(false);
                this.baq.sendMessage(requestJoinGroupMessage);
            } else if (view.equals(this.baq.bah)) {
                this.baq.finish();
            }
        }
    }
}
