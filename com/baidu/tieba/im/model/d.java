package com.baidu.tieba.im.model;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tieba.im.message.RequestGroupLevelMessage;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.a.d {

    /* renamed from: a  reason: collision with root package name */
    private long f1814a;

    public long a() {
        return this.f1814a;
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
        this.f1814a = intent.getLongExtra("group_id", 0L);
    }

    public void a(Bundle bundle) {
        this.f1814a = bundle.getLong("group_id");
    }

    private RequestGroupLevelMessage b(long j) {
        RequestGroupLevelMessage requestGroupLevelMessage = new RequestGroupLevelMessage();
        requestGroupLevelMessage.setGroupId(j);
        return requestGroupLevelMessage;
    }

    public void a(long j) {
        com.baidu.tieba.im.messageCenter.e.a().a(b(j));
    }

    public void a(com.baidu.tieba.im.messageCenter.g gVar) {
        com.baidu.tieba.im.messageCenter.e.a().a(103006, gVar);
    }

    public void b(com.baidu.tieba.im.messageCenter.g gVar) {
        com.baidu.tieba.im.messageCenter.e.a().a(gVar);
    }

    public void b(Bundle bundle) {
        bundle.putLong("group_id", this.f1814a);
    }
}
