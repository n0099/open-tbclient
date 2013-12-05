package com.baidu.tieba.im.chat;
/* loaded from: classes.dex */
class r implements com.baidu.tieba.im.a<Void> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ GroupSettingActivity f1604a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(GroupSettingActivity groupSettingActivity) {
        this.f1604a = groupSettingActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Void r4) {
        com.baidu.tieba.im.pushNotify.a.h().b(false, (com.baidu.tieba.im.a<Void>) null);
        this.f1604a.finish();
    }
}
