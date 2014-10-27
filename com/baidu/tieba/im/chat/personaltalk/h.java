package com.baidu.tieba.im.chat.personaltalk;
/* loaded from: classes.dex */
class h extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ g aSr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.aSr = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.b
    public Boolean doInBackground() {
        PersonalTalkSettingActivity personalTalkSettingActivity;
        long j;
        com.baidu.tieba.im.db.o MQ = com.baidu.tieba.im.db.o.MQ();
        personalTalkSettingActivity = this.aSr.aSq;
        j = personalTalkSettingActivity.userId;
        return Boolean.valueOf(MQ.fW(String.valueOf(j)));
    }
}
