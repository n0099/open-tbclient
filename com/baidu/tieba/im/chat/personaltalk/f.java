package com.baidu.tieba.im.chat.personaltalk;
/* loaded from: classes.dex */
class f extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ e a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.a = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Boolean a() {
        PersonalTalkSettingActivity personalTalkSettingActivity;
        long j;
        com.baidu.tieba.im.db.o c = com.baidu.tieba.im.db.o.c();
        personalTalkSettingActivity = this.a.a;
        j = personalTalkSettingActivity.c;
        return Boolean.valueOf(c.e(String.valueOf(j)));
    }
}
