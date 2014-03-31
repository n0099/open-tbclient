package com.baidu.tieba.im.model;

import android.content.Intent;
import android.os.Bundle;
/* loaded from: classes.dex */
public final class m extends com.baidu.adp.a.e {
    private long a;

    public final long a() {
        return this.a;
    }

    @Override // com.baidu.adp.a.e
    protected final boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.e
    public final boolean cancelLoadData() {
        return false;
    }

    public final void a(Intent intent) {
        this.a = intent.getLongExtra("group_id", 0L);
    }

    public final void a(Bundle bundle) {
        this.a = bundle.getLong("group_id");
    }

    public final void a(long j, int i) {
        com.baidu.tieba.im.message.al alVar = new com.baidu.tieba.im.message.al();
        alVar.b(j);
        if (alVar.f() == 0) {
            alVar.b(i);
        }
        super.sendMessage(alVar);
    }

    public final void b(Bundle bundle) {
        bundle.putLong("group_id", this.a);
    }
}
