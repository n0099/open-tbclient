package com.baidu.tieba.im.chat;
/* loaded from: classes.dex */
class x implements com.baidu.tieba.im.a<Void> {
    final /* synthetic */ GroupSettingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(GroupSettingActivity groupSettingActivity) {
        this.a = groupSettingActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Void r4) {
        aa aaVar;
        aaVar = this.a.b;
        com.baidu.tieba.im.db.a.b(aaVar.c());
        com.baidu.tieba.im.c.a.h().b(false, (com.baidu.tieba.im.a<Void>) null);
        this.a.finish();
    }
}
