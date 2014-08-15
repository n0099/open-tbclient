package com.baidu.tieba.im.chat;
/* loaded from: classes.dex */
class bj extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ bi a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(bi biVar) {
        this.a = biVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Boolean a() {
        GroupSettingActivity groupSettingActivity;
        bm bmVar;
        com.baidu.tieba.im.db.c a = com.baidu.tieba.im.db.c.a();
        groupSettingActivity = this.a.a;
        bmVar = groupSettingActivity.b;
        return Boolean.valueOf(a.d(bmVar.b()));
    }
}
