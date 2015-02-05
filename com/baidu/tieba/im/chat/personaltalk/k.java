package com.baidu.tieba.im.chat.personaltalk;
/* loaded from: classes.dex */
class k extends com.baidu.tieba.im.h<Boolean> {
    final /* synthetic */ j aVk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.aVk = jVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Boolean doInBackground() {
        PersonalTalkSettingActivity personalTalkSettingActivity;
        long j;
        com.baidu.tieba.im.db.o Nf = com.baidu.tieba.im.db.o.Nf();
        personalTalkSettingActivity = this.aVk.aVj;
        j = personalTalkSettingActivity.userId;
        return Boolean.valueOf(Nf.gn(String.valueOf(j)));
    }
}
