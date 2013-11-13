package com.baidu.tieba.im.chat;
/* loaded from: classes.dex */
class n implements com.baidu.tieba.im.a<Boolean> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ GroupSettingActivity f1556a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(GroupSettingActivity groupSettingActivity) {
        this.f1556a = groupSettingActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        v vVar;
        v vVar2;
        if (bool == null || !bool.equals(true)) {
            vVar = this.f1556a.f1490a;
            vVar.s().b();
            return;
        }
        vVar2 = this.f1556a.f1490a;
        vVar2.s().a();
    }
}
