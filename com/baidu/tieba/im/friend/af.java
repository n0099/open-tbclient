package com.baidu.tieba.im.friend;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tieba.im.message.RequestCommitInviteMessage;
import protobuf.CommitInviteMsg.DataReq;
/* loaded from: classes.dex */
public class af extends com.baidu.adp.base.b {
    private ag a = null;
    private RequestCommitInviteMessage b;
    private int c;
    private int d;

    @Override // com.baidu.adp.base.b
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.b
    public boolean cancelLoadData() {
        if (this.a != null) {
            this.a.cancel();
        }
        super.cancelMessage();
        return true;
    }

    public void a(Intent intent) {
        if (intent != null) {
            this.c = intent.getIntExtra("gid", -1);
            this.d = intent.getIntExtra("groupid", -1);
        }
    }

    public void a(Bundle bundle) {
        if (bundle != null) {
            this.c = bundle.getInt("gid", -1);
            this.d = bundle.getInt("groupid", -1);
        }
    }

    public void b(Bundle bundle) {
        bundle.putInt("gid", this.c);
        bundle.putInt("groupid", this.d);
    }

    public void a(String str) {
        if (this.a != null) {
            this.a.cancel();
        }
        this.a = new ag(this, null);
        this.a.execute(str);
    }

    public void b(String str) {
        this.b = a(this.c, this.d, str);
        super.sendMessage(this.b);
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
}
