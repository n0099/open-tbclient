package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.SingleRunnable;
/* loaded from: classes.dex */
class w extends SingleRunnable<Void> {
    final /* synthetic */ GroupSettingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(GroupSettingActivity groupSettingActivity) {
        this.a = groupSettingActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public Void b() {
        aa aaVar;
        aaVar = this.a.b;
        com.baidu.tieba.im.db.a.a(aaVar.c());
        return null;
    }
}
