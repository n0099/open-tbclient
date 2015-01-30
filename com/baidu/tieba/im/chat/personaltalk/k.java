package com.baidu.tieba.im.chat.personaltalk;
/* loaded from: classes.dex */
class k extends com.baidu.tieba.im.h<Boolean> {
    final /* synthetic */ j aVl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.aVl = jVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Boolean doInBackground() {
        PersonalTalkSettingActivity personalTalkSettingActivity;
        long j;
        com.baidu.tieba.im.db.o Nk = com.baidu.tieba.im.db.o.Nk();
        personalTalkSettingActivity = this.aVl.aVk;
        j = personalTalkSettingActivity.userId;
        return Boolean.valueOf(Nk.gq(String.valueOf(j)));
    }
}
