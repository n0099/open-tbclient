package com.baidu.tieba.im.model;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.android.pushservice.PushConstants;
import protobuf.CommitInviteMsg.CommitInviteMsgReq;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.a.d {
    private i a = null;
    private com.baidu.tieba.im.message.x b;
    private int c;
    private int d;

    @Override // com.baidu.adp.a.d
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.d
    public boolean cancelLoadData() {
        if (this.a != null) {
            this.a.cancel();
        }
        if (this.b != null) {
            com.baidu.tieba.im.messageCenter.e.a().b(this.b);
            return true;
        }
        return true;
    }

    public void a(Intent intent) {
        if (intent != null) {
            this.c = intent.getIntExtra(PushConstants.EXTRA_GID, -1);
            this.d = intent.getIntExtra("groupid", -1);
        }
    }

    public void a(Bundle bundle) {
        if (bundle != null) {
            this.c = bundle.getInt(PushConstants.EXTRA_GID, -1);
            this.d = bundle.getInt("groupid", -1);
        }
    }

    public void b(Bundle bundle) {
        bundle.putInt(PushConstants.EXTRA_GID, this.c);
        bundle.putInt("groupid", this.d);
    }

    public void a(String str) {
        if (this.a != null) {
            this.a.cancel();
        }
        this.a = new i(this);
        this.a.execute(str);
    }

    public void b(String str) {
        this.b = a(this.c, this.d, str);
        com.baidu.tieba.im.messageCenter.e.a().a(this.b);
    }

    private com.baidu.tieba.im.message.x a(int i, int i2, String str) {
        CommitInviteMsgReq.DataReq build = CommitInviteMsgReq.DataReq.newBuilder().a(i).b(5).a(str).b("{\"type\":" + String.valueOf(1) + ",\"groupId\":" + String.valueOf(i2) + "}").build();
        com.baidu.tieba.im.message.x xVar = new com.baidu.tieba.im.message.x();
        xVar.a(build);
        return xVar;
    }
}
