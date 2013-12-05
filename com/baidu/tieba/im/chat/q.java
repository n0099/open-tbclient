package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.SingleRunnable;
/* loaded from: classes.dex */
class q extends SingleRunnable<Void> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ GroupSettingActivity f1603a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(GroupSettingActivity groupSettingActivity) {
        this.f1603a = groupSettingActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public Void b() {
        u uVar;
        uVar = this.f1603a.b;
        com.baidu.tieba.im.db.a.a(uVar.c());
        return null;
    }
}
