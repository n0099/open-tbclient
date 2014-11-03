package com.baidu.tieba.im.friend;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.tieba.im.message.RequestCommitInviteMessage;
import protobuf.CommitInviteMsg.DataReq;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends com.baidu.adp.base.e {
    private RequestCommitInviteMessage aWu;
    private int aWv;
    private int aWw;

    public x(Context context) {
        super(context);
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    public void initWithIntent(Intent intent) {
        if (intent != null) {
            this.aWv = intent.getIntExtra("gid", -1);
            this.aWw = intent.getIntExtra("groupid", -1);
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.aWv = bundle.getInt("gid", -1);
            this.aWw = bundle.getInt("groupid", -1);
        }
    }

    public void i(Bundle bundle) {
        bundle.putInt("gid", this.aWv);
        bundle.putInt("groupid", this.aWw);
    }

    public void gd(String str) {
        this.aWu = b(this.aWv, this.aWw, str);
        super.sendMessage(this.aWu);
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

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return true;
    }
}
