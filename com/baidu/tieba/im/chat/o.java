package com.baidu.tieba.im.chat;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.SingleRunnable;
/* loaded from: classes.dex */
class o extends SingleRunnable<Void> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ GroupSettingActivity f1557a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(GroupSettingActivity groupSettingActivity) {
        this.f1557a = groupSettingActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public Void b() {
        s sVar;
        s sVar2;
        String A = TiebaApplication.A();
        sVar = this.f1557a.b;
        com.baidu.tieba.im.groupInfo.v.a(A, sVar.c(), false);
        String A2 = TiebaApplication.A();
        sVar2 = this.f1557a.b;
        com.baidu.tieba.im.groupInfo.v.c(A2, sVar2.c(), false);
        return null;
    }
}
