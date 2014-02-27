package com.baidu.tieba.im.model;

import android.content.Intent;
import android.os.Bundle;
/* loaded from: classes.dex */
public final class f extends com.baidu.adp.a.d {
    private long a;

    public final long a() {
        return this.a;
    }

    @Override // com.baidu.adp.a.d
    protected final boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.d
    public final boolean cancelLoadData() {
        return false;
    }

    public final void a(Intent intent) {
        this.a = intent.getLongExtra("group_id", 0L);
    }

    public final void a(Bundle bundle) {
        this.a = bundle.getLong("group_id");
    }

    public final void a(long j) {
        com.baidu.tieba.im.message.ap apVar = new com.baidu.tieba.im.message.ap();
        apVar.a(j);
        com.baidu.tieba.im.messageCenter.d.a().a(apVar);
    }

    public final void b(Bundle bundle) {
        bundle.putLong("group_id", this.a);
    }
}
