package com.baidu.tieba.im.chat;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.SingleRunnable;
/* loaded from: classes.dex */
class p extends SingleRunnable<Void> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ GroupSettingActivity f1466a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(GroupSettingActivity groupSettingActivity) {
        this.f1466a = groupSettingActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public Void b() {
        t tVar;
        t tVar2;
        String C = TiebaApplication.C();
        tVar = this.f1466a.b;
        com.baidu.tieba.im.groupInfo.v.a(C, tVar.c(), false);
        String C2 = TiebaApplication.C();
        tVar2 = this.f1466a.b;
        com.baidu.tieba.im.groupInfo.v.c(C2, tVar2.c(), false);
        return null;
    }
}
