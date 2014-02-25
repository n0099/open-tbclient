package com.baidu.tieba.im.chat.personaltalk;
/* loaded from: classes.dex */
class f extends com.baidu.tieba.im.c<Boolean> {
    final /* synthetic */ e a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.a = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.c
    /* renamed from: a */
    public Boolean b() {
        PersonalTalkSettingActivity personalTalkSettingActivity;
        long j;
        com.baidu.tieba.im.db.q a = com.baidu.tieba.im.db.q.a();
        personalTalkSettingActivity = this.a.a;
        j = personalTalkSettingActivity.c;
        return Boolean.valueOf(a.d(String.valueOf(j)));
    }
}
