package com.baidu.tieba.im.friend;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tieba.im.message.RequestCommitInviteMessage;
import protobuf.CommitInviteMsg.DataReq;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae extends com.baidu.adp.base.e {
    private RequestCommitInviteMessage a;
    private int b;
    private int c;

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    public void a(Intent intent) {
        if (intent != null) {
            this.b = intent.getIntExtra("gid", -1);
            this.c = intent.getIntExtra("groupid", -1);
        }
    }

    public void a(Bundle bundle) {
        if (bundle != null) {
            this.b = bundle.getInt("gid", -1);
            this.c = bundle.getInt("groupid", -1);
        }
    }

    public void b(Bundle bundle) {
        bundle.putInt("gid", this.b);
        bundle.putInt("groupid", this.c);
    }

    public void a(String str) {
        this.a = a(this.b, this.c, str);
        super.sendMessage(this.a);
    }

    private RequestCommitInviteMessage a(int i, int i2, String str) {
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
