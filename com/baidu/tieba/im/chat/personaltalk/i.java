package com.baidu.tieba.im.chat.personaltalk;
/* loaded from: classes.dex */
class i extends com.baidu.tieba.im.h<Boolean> {
    final /* synthetic */ h aTR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.aTR = hVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Boolean doInBackground() {
        PersonalTalkSettingActivity personalTalkSettingActivity;
        long j;
        com.baidu.tieba.im.db.o MO = com.baidu.tieba.im.db.o.MO();
        personalTalkSettingActivity = this.aTR.aTQ;
        j = personalTalkSettingActivity.userId;
        return Boolean.valueOf(MO.gl(String.valueOf(j)));
    }
}
