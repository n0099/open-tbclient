package com.baidu.tieba.im.chat;
/* loaded from: classes.dex */
class bj implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ GroupSettingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(GroupSettingActivity groupSettingActivity) {
        this.a = groupSettingActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        br brVar;
        br brVar2;
        if (bool == null || !bool.equals(true)) {
            brVar = this.a.a;
            brVar.r().b();
            return;
        }
        brVar2 = this.a.a;
        brVar2.r().a();
    }
}
