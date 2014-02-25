package com.baidu.tieba.im.chat;
/* loaded from: classes.dex */
class as extends com.baidu.tieba.im.c<Boolean> {
    final /* synthetic */ ar a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(ar arVar) {
        this.a = arVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.c
    /* renamed from: a */
    public Boolean b() {
        GroupSettingActivity groupSettingActivity;
        aw awVar;
        com.baidu.tieba.im.db.b a = com.baidu.tieba.im.db.b.a();
        groupSettingActivity = this.a.a;
        awVar = groupSettingActivity.b;
        return Boolean.valueOf(a.e(awVar.c()));
    }
}
