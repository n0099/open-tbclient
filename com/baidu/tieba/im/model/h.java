package com.baidu.tieba.im.model;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.android.pushservice.PushConstants;
import protobuf.CommitInviteMsg.CommitInviteMsgReq;
/* loaded from: classes.dex */
public final class h extends com.baidu.adp.a.d {
    private i a = null;
    private com.baidu.tieba.im.message.ag b;
    private int c;
    private int d;

    @Override // com.baidu.adp.a.d
    protected final boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.d
    public final boolean cancelLoadData() {
        if (this.a != null) {
            this.a.cancel();
        }
        if (this.b != null) {
            com.baidu.tieba.im.messageCenter.d.a().b(this.b);
            return true;
        }
        return true;
    }

    public final void a(Intent intent) {
        if (intent != null) {
            this.c = intent.getIntExtra(PushConstants.EXTRA_GID, -1);
            this.d = intent.getIntExtra("groupid", -1);
        }
    }

    public final void a(Bundle bundle) {
        if (bundle != null) {
            this.c = bundle.getInt(PushConstants.EXTRA_GID, -1);
            this.d = bundle.getInt("groupid", -1);
        }
    }

    public final void b(Bundle bundle) {
        bundle.putInt(PushConstants.EXTRA_GID, this.c);
        bundle.putInt("groupid", this.d);
    }

    public final void a(String str) {
        if (this.a != null) {
            this.a.cancel();
        }
        this.a = new i(this, (byte) 0);
        this.a.execute(str);
    }

    public final void b(String str) {
        int i = this.c;
        CommitInviteMsgReq.DataReq build = CommitInviteMsgReq.DataReq.newBuilder().a(i).b(5).a(str).b("{\"type\":" + String.valueOf(1) + ",\"groupId\":" + String.valueOf(this.d) + "}").build();
        com.baidu.tieba.im.message.ag agVar = new com.baidu.tieba.im.message.ag();
        agVar.a(build);
        this.b = agVar;
        com.baidu.tieba.im.messageCenter.d.a().a(this.b);
    }
}
