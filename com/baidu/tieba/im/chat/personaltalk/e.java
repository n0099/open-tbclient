package com.baidu.tieba.im.chat.personaltalk;
/* loaded from: classes.dex */
class e extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ d b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.b = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Boolean a() {
        PersonalTalkSettingActivity personalTalkSettingActivity;
        long j;
        com.baidu.tieba.im.db.o d = com.baidu.tieba.im.db.o.d();
        personalTalkSettingActivity = this.b.a;
        j = personalTalkSettingActivity.c;
        return Boolean.valueOf(d.e(String.valueOf(j)));
    }
}
