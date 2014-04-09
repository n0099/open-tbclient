package com.baidu.tieba.im.chat.personaltalk;
/* loaded from: classes.dex */
final class e extends com.baidu.tieba.im.m<Boolean> {
    final /* synthetic */ d b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.b = dVar;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.m
    public final /* synthetic */ Boolean a() {
        PersonalTalkSettingActivity personalTalkSettingActivity;
        long j;
        com.baidu.tieba.im.db.o d = com.baidu.tieba.im.db.o.d();
        personalTalkSettingActivity = this.b.a;
        j = personalTalkSettingActivity.c;
        return Boolean.valueOf(d.e(String.valueOf(j)));
    }
}
