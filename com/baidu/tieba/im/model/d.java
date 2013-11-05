package com.baidu.tieba.im.model;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tieba.im.message.RequestGroupLevelMessage;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.a.d {

    /* renamed from: a  reason: collision with root package name */
    private long f1660a;

    public long a() {
        return this.f1660a;
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
        this.f1660a = intent.getLongExtra("group_id", 0L);
    }

    public void a(Bundle bundle) {
        this.f1660a = bundle.getLong("group_id");
    }

    private RequestGroupLevelMessage b(long j) {
        RequestGroupLevelMessage requestGroupLevelMessage = new RequestGroupLevelMessage();
        requestGroupLevelMessage.setGroupId(j);
        return requestGroupLevelMessage;
    }

    public void a(long j) {
        com.baidu.tieba.im.messageCenter.f.a().a(b(j));
    }

    public void a(com.baidu.tieba.im.messageCenter.h hVar) {
        com.baidu.tieba.im.messageCenter.f.a().a(103006, hVar);
    }

    public void b(com.baidu.tieba.im.messageCenter.h hVar) {
        com.baidu.tieba.im.messageCenter.f.a().a(hVar);
    }

    public void b(Bundle bundle) {
        bundle.putLong("group_id", this.f1660a);
    }
}
