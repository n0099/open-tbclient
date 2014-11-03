package com.baidu.tieba.im.chat.personaltalk;
/* loaded from: classes.dex */
class h extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ g aSF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.aSF = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.b
    public Boolean doInBackground() {
        PersonalTalkSettingActivity personalTalkSettingActivity;
        long j;
        com.baidu.tieba.im.db.o MU = com.baidu.tieba.im.db.o.MU();
        personalTalkSettingActivity = this.aSF.aSE;
        j = personalTalkSettingActivity.userId;
        return Boolean.valueOf(MU.fW(String.valueOf(j)));
    }
}
