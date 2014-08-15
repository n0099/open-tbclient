package com.baidu.tieba.im.groupInfo;

import android.view.View;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
class d implements View.OnClickListener {
    final /* synthetic */ ApplyJoinGroupActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ApplyJoinGroupActivity applyJoinGroupActivity) {
        this.a = applyJoinGroupActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.equals(this.a.f)) {
                if (!UtilHelper.isNetOk()) {
                    this.a.showToast(com.baidu.tieba.x.neterror);
                    return;
                }
                RequestJoinGroupMessage requestJoinGroupMessage = new RequestJoinGroupMessage();
                requestJoinGroupMessage.setGroupId(com.baidu.adp.lib.e.b.a(this.a.k, 0));
                requestJoinGroupMessage.setUserMsg(this.a.b.getText().toString());
                requestJoinGroupMessage.setJoinType(this.a.p);
                requestJoinGroupMessage.setInviteUserId(this.a.n);
                this.a.f.setEnabled(false);
                this.a.sendMessage(requestJoinGroupMessage);
            } else if (view.equals(this.a.e)) {
                this.a.finish();
            }
        }
    }
}
