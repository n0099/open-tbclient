package com.baidu.tieba.im.chat;
/* loaded from: classes.dex */
class r implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ GroupSettingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(GroupSettingActivity groupSettingActivity) {
        this.a = groupSettingActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        ad adVar;
        ad adVar2;
        if (bool == null || !bool.equals(true)) {
            adVar = this.a.a;
            adVar.u().b();
            return;
        }
        adVar2 = this.a.a;
        adVar2.u().a();
    }
}
