package com.baidu.tieba.im.friend;

import android.content.Intent;
import android.os.Bundle;
import protobuf.CommitInviteMsg.CommitInviteMsgReq;
/* loaded from: classes.dex */
public final class af extends com.baidu.adp.a.e {
    private ag a = null;
    private com.baidu.tieba.im.message.aa b;
    private int c;
    private int d;

    @Override // com.baidu.adp.a.e
    protected final boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.e
    public final boolean cancelLoadData() {
        if (this.a != null) {
            this.a.cancel();
        }
        super.cancelMessage();
        return true;
    }

    public final void a(Intent intent) {
        if (intent != null) {
            this.c = intent.getIntExtra("gid", -1);
            this.d = intent.getIntExtra("groupid", -1);
        }
    }

    public final void a(Bundle bundle) {
        if (bundle != null) {
            this.c = bundle.getInt("gid", -1);
            this.d = bundle.getInt("groupid", -1);
        }
    }

    public final void b(Bundle bundle) {
        bundle.putInt("gid", this.c);
        bundle.putInt("groupid", this.d);
    }

    public final void a(String str) {
        if (this.a != null) {
            this.a.cancel();
        }
        this.a = new ag(this, (byte) 0);
        this.a.execute(str);
    }

    public final void b(String str) {
        int i = this.c;
        CommitInviteMsgReq.DataReq build = CommitInviteMsgReq.DataReq.newBuilder().a(i).b(5).a(str).b("{\"type\":" + String.valueOf(1) + ",\"groupId\":" + String.valueOf(this.d) + "}").build();
        com.baidu.tieba.im.message.aa aaVar = new com.baidu.tieba.im.message.aa();
        aaVar.a(build);
        this.b = aaVar;
        super.sendMessage(this.b);
    }
}
