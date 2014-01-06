package com.baidu.tieba.im.chat;
/* loaded from: classes.dex */
class w implements com.baidu.tieba.im.a<Void> {
    final /* synthetic */ GroupSettingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(GroupSettingActivity groupSettingActivity) {
        this.a = groupSettingActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Void r4) {
        z zVar;
        zVar = this.a.b;
        com.baidu.tieba.im.db.a.b(zVar.c());
        com.baidu.tieba.im.c.a.h().b(false, (com.baidu.tieba.im.a<Void>) null);
        this.a.finish();
    }
}
