package com.baidu.tieba.im.chat;
/* loaded from: classes.dex */
class aj implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ GroupSettingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(GroupSettingActivity groupSettingActivity) {
        this.a = groupSettingActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        av avVar;
        av avVar2;
        if (bool == null || !bool.equals(true)) {
            avVar = this.a.a;
            avVar.u().b();
            return;
        }
        avVar2 = this.a.a;
        avVar2.u().a();
    }
}
