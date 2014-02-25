package com.baidu.tieba.im.chat;
/* loaded from: classes.dex */
class aq implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ GroupSettingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(GroupSettingActivity groupSettingActivity) {
        this.a = groupSettingActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        az azVar;
        az azVar2;
        if (bool == null || !bool.equals(true)) {
            azVar = this.a.a;
            azVar.u().b();
            return;
        }
        azVar2 = this.a.a;
        azVar2.u().a();
    }
}
