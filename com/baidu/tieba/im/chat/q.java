package com.baidu.tieba.im.chat;
/* loaded from: classes.dex */
class q implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ GroupSettingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(GroupSettingActivity groupSettingActivity) {
        this.a = groupSettingActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        ac acVar;
        ac acVar2;
        if (bool == null || !bool.equals(true)) {
            acVar = this.a.a;
            acVar.u().b();
            return;
        }
        acVar2 = this.a.a;
        acVar2.u().a();
    }
}
