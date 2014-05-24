package com.baidu.tieba.im.chat;
/* loaded from: classes.dex */
class bk extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ bj b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(bj bjVar) {
        this.b = bjVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Boolean a() {
        GroupSettingActivity groupSettingActivity;
        bn bnVar;
        com.baidu.tieba.im.db.c a = com.baidu.tieba.im.db.c.a();
        groupSettingActivity = this.b.a;
        bnVar = groupSettingActivity.b;
        return Boolean.valueOf(a.e(bnVar.b()));
    }
}
