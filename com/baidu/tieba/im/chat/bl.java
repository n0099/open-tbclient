package com.baidu.tieba.im.chat;
/* loaded from: classes.dex */
class bl extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ bk b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(bk bkVar) {
        this.b = bkVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Boolean a() {
        GroupSettingActivity groupSettingActivity;
        bo boVar;
        com.baidu.tieba.im.db.c a = com.baidu.tieba.im.db.c.a();
        groupSettingActivity = this.b.a;
        boVar = groupSettingActivity.b;
        return Boolean.valueOf(a.e(boVar.b()));
    }
}
