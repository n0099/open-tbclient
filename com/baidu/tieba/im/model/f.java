package com.baidu.tieba.im.model;

import android.content.Intent;
import android.os.Bundle;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.a.d {
    private long a;

    public long a() {
        return this.a;
    }

    @Override // com.baidu.adp.a.d
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.d
    public boolean cancelLoadData() {
        return false;
    }

    public void a(Intent intent) {
        this.a = intent.getLongExtra("group_id", 0L);
    }

    public void a(Bundle bundle) {
        this.a = bundle.getLong("group_id");
    }

    private com.baidu.tieba.im.message.aj b(long j) {
        com.baidu.tieba.im.message.aj ajVar = new com.baidu.tieba.im.message.aj();
        ajVar.a(j);
        return ajVar;
    }

    public void a(long j) {
        com.baidu.tieba.im.messageCenter.e.a().a(b(j));
    }

    public void a(com.baidu.tieba.im.messageCenter.g gVar) {
        com.baidu.tieba.im.messageCenter.e.a().a(103006, gVar);
        com.baidu.tieba.im.messageCenter.e.a().a(103105, gVar);
    }

    public void b(com.baidu.tieba.im.messageCenter.g gVar) {
        com.baidu.tieba.im.messageCenter.e.a().a(gVar);
    }

    public void b(Bundle bundle) {
        bundle.putLong("group_id", this.a);
    }
}
