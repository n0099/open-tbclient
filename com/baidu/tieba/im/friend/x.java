package com.baidu.tieba.im.friend;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.core.atomData.InviteFriendListActivityConfig;
import com.baidu.tieba.im.message.RequestCommitInviteMessage;
import protobuf.CommitInviteMsg.DataReq;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends com.baidu.adp.base.f<InviteFriendListActivity> {
    private RequestCommitInviteMessage baM;
    private int baN;
    private int baO;

    public x(InviteFriendListActivity inviteFriendListActivity) {
        super(inviteFriendListActivity.getPageContext());
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        return false;
    }

    public void initWithIntent(Intent intent) {
        if (intent != null) {
            this.baN = intent.getIntExtra("gid", -1);
            this.baO = intent.getIntExtra(InviteFriendListActivityConfig.GROUP_ID, -1);
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.baN = bundle.getInt("gid", -1);
            this.baO = bundle.getInt(InviteFriendListActivityConfig.GROUP_ID, -1);
        }
    }

    public void j(Bundle bundle) {
        bundle.putInt("gid", this.baN);
        bundle.putInt(InviteFriendListActivityConfig.GROUP_ID, this.baO);
    }

    public void gH(String str) {
        this.baM = b(this.baN, this.baO, str);
        super.sendMessage(this.baM);
    }

    private RequestCommitInviteMessage b(int i, int i2, String str) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.groupId = Integer.valueOf(i);
        builder.msgType = 5;
        builder.toUids = str;
        builder.content = "{\"type\":" + String.valueOf(1) + ",\"groupId\":" + String.valueOf(i2) + "}";
        RequestCommitInviteMessage requestCommitInviteMessage = new RequestCommitInviteMessage();
        requestCommitInviteMessage.setReqData(builder.build(false));
        return requestCommitInviteMessage;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        return true;
    }
}
