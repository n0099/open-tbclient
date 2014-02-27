package com.baidu.tieba.im.chat.personaltalk;
/* loaded from: classes.dex */
final class f extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ e a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.a = eVar;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.b
    public final /* synthetic */ Boolean a() {
        PersonalTalkSettingActivity personalTalkSettingActivity;
        long j;
        com.baidu.tieba.im.db.q a = com.baidu.tieba.im.db.q.a();
        personalTalkSettingActivity = this.a.a;
        j = personalTalkSettingActivity.c;
        return Boolean.valueOf(a.d(String.valueOf(j)));
    }
}
