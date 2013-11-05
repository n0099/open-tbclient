package com.baidu.tieba.im.chat;
/* loaded from: classes.dex */
class o implements com.baidu.tieba.im.a<Boolean> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ GroupSettingActivity f1465a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(GroupSettingActivity groupSettingActivity) {
        this.f1465a = groupSettingActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        w wVar;
        w wVar2;
        if (bool == null || !bool.equals(true)) {
            wVar = this.f1465a.f1398a;
            wVar.s().b();
            return;
        }
        wVar2 = this.f1465a.f1398a;
        wVar2.s().a();
    }
}
