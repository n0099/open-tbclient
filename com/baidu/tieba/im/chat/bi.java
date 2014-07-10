package com.baidu.tieba.im.chat;
/* loaded from: classes.dex */
class bi implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ GroupSettingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(GroupSettingActivity groupSettingActivity) {
        this.a = groupSettingActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        bq bqVar;
        bq bqVar2;
        if (bool == null || !bool.equals(true)) {
            bqVar = this.a.a;
            bqVar.r().d();
            return;
        }
        bqVar2 = this.a.a;
        bqVar2.r().c();
    }
}
